import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

abstract class Account {
	int accountNumber;
	String holderName;
	double balance;
	boolean isFrozen; // For salary freezing or other lifecycle events

	Account(int accNo, String name, double bal) {
		accountNumber = accNo;
		holderName = name;
		balance = bal;
		isFrozen = false;
	}

	abstract void deposit(double amount, Bank bank); // logs transaction via bank

	abstract boolean withdraw(double amount, Bank bank); // logs transaction via bank

	abstract void applyMonthlyInterest(Bank bank); // interest rules per account

	abstract String getType();

	void displaySummary() {
		System.out.printf("[%s] AccNo: %d | Name: %s | Balance: %.2f%s\n", getType(), accountNumber, holderName,
				balance, (isFrozen ? " [FROZEN]" : ""));
	}
}

class SavingsAccount extends Account {
	double minBalance = 10000.0;
	double annualInterestRate = 0.04; // 4% annual

	SavingsAccount(int a, String n, double b) {
		super(a, n, b);
	}

	void deposit(double amount, Bank bank) {
		balance += amount;
		bank.logTransaction(new Transaction(accountNumber, "DEPOSIT", amount));
	}

	boolean withdraw(double amount, Bank bank) {
		if (isFrozen) {
			System.out.println("Account is frozen. Withdrawal denied.");
			return false;
		}
		if (balance - amount >= minBalance) {
			balance -= amount;
			bank.logTransaction(new Transaction(accountNumber, "WITHDRAW", amount));
			return true;
		} else {
			System.out.println("Withdrawal would breach minimum average balance (" + minBalance + ").");
			return false;
		}
	}

	void applyMonthlyInterest(Bank bank) {
		double monthlyRate = annualInterestRate / 12.0;
		double interest = balance * monthlyRate;
		balance += interest;
		bank.logTransaction(new Transaction(accountNumber, "INTEREST", interest));
	}

	String getType() {
		return "Savings";
	}
}

class SalaryAccount extends Account {
	int monthsNoTransaction;
	double annualInterestRate = 0.04; // 4% annual

	SalaryAccount(int a, String n, double b) {
		super(a, n, b);
		monthsNoTransaction = 0;
	}

	void deposit(double amount, Bank bank) {
		if (isFrozen) {
			System.out.println("Account was frozen. Accepting deposit will unfreeze.");
			isFrozen = false;
		}
		balance += amount;
		monthsNoTransaction = 0;
		bank.logTransaction(new Transaction(accountNumber, "DEPOSIT", amount));
	}

	boolean withdraw(double amount, Bank bank) {
		if (isFrozen) {
			System.out.println("Account is frozen. Withdrawal denied.");
			return false;
		}
		if (balance >= amount) {
			balance -= amount;
			monthsNoTransaction = 0;
			bank.logTransaction(new Transaction(accountNumber, "WITHDRAW", amount));
			return true;
		} else {
			System.out.println("Insufficient balance.");
			return false;
		}
	}

	void monthPassed(Bank bank) {
		monthsNoTransaction++;
		if (monthsNoTransaction >= 2) {
			isFrozen = true;
			bank.logTransaction(new Transaction(accountNumber, "ACCOUNT_FROZEN", 0.0));
			System.out.println("Salary account " + accountNumber + " has been frozen due to inactivity.");
		}
	}

	void applyMonthlyInterest(Bank bank) {
		double monthlyRate = annualInterestRate / 12.0;
		double interest = balance * monthlyRate;
		balance += interest;
		bank.logTransaction(new Transaction(accountNumber, "INTEREST", interest));
	}

	String getType() {
		return "Salary";
	}
}

class CurrentAccount extends Account {
	double overdraftLimit;
	double annualInterestRate = 0.005; // 0.5% annual on positive balance (nominal)

	CurrentAccount(int a, String n, double b, double limit) {
		super(a, n, b);
		overdraftLimit = limit;
	}

	void deposit(double amount, Bank bank) {
		balance += amount;
		bank.logTransaction(new Transaction(accountNumber, "DEPOSIT", amount));
	}

	boolean withdraw(double amount, Bank bank) {
		if (isFrozen) {
			System.out.println("Account is frozen. Withdrawal denied.");
			return false;
		}
		if (balance + overdraftLimit >= amount) {
			balance -= amount;
			bank.logTransaction(new Transaction(accountNumber, "WITHDRAW", amount));
			return true;
		} else {
			System.out.println("Withdrawal exceeds overdraft limit.");
			return false;
		}
	}

	void applyMonthlyInterest(Bank bank) {
		// minimal interest; for overdrawn no interest credit; implement as small credit
		// on positive balances
		if (balance > 0) {
			double monthlyRate = annualInterestRate / 12.0;
			double interest = balance * monthlyRate;
			balance += interest;
			bank.logTransaction(new Transaction(accountNumber, "INTEREST", interest));
		} else {
			// optionally charge interest on overdraft - skipped or could be added
		}
	}

	String getType() {
		return "Current";
	}
}

class LoanAccount extends Account {
	double annualInterestRate = 0.08; // 8% annual on outstanding loan (negative balance)

	LoanAccount(int a, String n, double loanAmount) {
		// loanAmount > 0 ; stored as negative balance
		super(a, n, -loanAmount);
	}

	void deposit(double amount, Bank bank) {
		// deposit here is repayment -> balance increases toward zero
		balance += amount;
		bank.logTransaction(new Transaction(accountNumber, "LOAN_REPAY", amount));
	}

	boolean withdraw(double amount, Bank bank) {
		// No withdrawal allowed from loan account
		System.out.println("Withdrawals not allowed from Loan account.");
		return false;
	}

	void applyMonthlyInterest(Bank bank) {
		if (balance < 0) {
			double monthlyRate = annualInterestRate / 12.0;
			double interest = balance * monthlyRate; // negative * positive => negative interest (increases loan)
			balance += interest; // since interest is negative, loan increases
			bank.logTransaction(new Transaction(accountNumber, "LOAN_INTEREST", interest));
		}
	}

	String getType() {
		return "Loan";
	}
}

// Transaction class for logging
class Transaction {
	int accountNumber;
	String type; // e.g., DEPOSIT, WITHDRAW, INTEREST, ACCOUNT_CREATED, ACCOUNT_FROZEN,
					// LOAN_REPAY
	double amount;
	LocalDateTime timestamp;

	Transaction(int accNo, String t, double amt) {
		accountNumber = accNo;
		type = t;
		amount = amt;
		timestamp = LocalDateTime.now();
	}

	String format() {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return String.format("%s | Acc: %d | %-12s | Amount: %8.2f", timestamp.format(f), accountNumber, type, amount);
	}
}

// Model: Bank holds accounts in an array with extra space and transaction log array
class Bank {
	Account[] accounts = new Account[50]; // extra space
	int accountCount = 0;

	Transaction[] transactions = new Transaction[500]; // daily log capacity
	int transactionCount = 0;

	Bank() {
		// 5 hardcoded accounts as required:
		accounts[accountCount++] = new SavingsAccount(101, "Arjun", 15000.0);
		accounts[accountCount++] = new SalaryAccount(102, "Meera", 12000.0);
		accounts[accountCount++] = new CurrentAccount(103, "Ravi", 8000.0, 5000.0);
		accounts[accountCount++] = new LoanAccount(104, "Karan", 50000.0); // stored as -50000
		accounts[accountCount++] = new SavingsAccount(105, "Neha", 20000.0);
		// Log account creation
		for (int i = 0; i < accountCount; i++) {
			logTransaction(new Transaction(accounts[i].accountNumber, "ACCOUNT_CREATED", 0.0));
		}
	}

	boolean addAccount(Account a) {
		if (accountCount < accounts.length) {
			accounts[accountCount++] = a;
			logTransaction(new Transaction(a.accountNumber, "ACCOUNT_CREATED", 0.0));
			return true;
		} else {
			System.out.println("Bank full. Cannot add more accounts.");
			return false;
		}
	}

	Account findAccount(int accNo) {
		for (int i = 0; i < accountCount; i++) {
			if (accounts[i].accountNumber == accNo)
				return accounts[i];
		}
		return null;
	}

	void logTransaction(Transaction t) {
		if (transactionCount < transactions.length) {
			transactions[transactionCount++] = t;
		} else {
			System.out.println(
					"Transaction log capacity reached. Oldest transactions will be lost in this simple implementation.");
			// naive overwrite oldest
			for (int i = 1; i < transactions.length; i++)
				transactions[i - 1] = transactions[i];
			transactions[transactions.length - 1] = t;
		}
	}

	void showAllAccounts() {
		System.out.println("---- All Accounts ----");
		for (int i = 0; i < accountCount; i++) {
			accounts[i].displaySummary();
		}
	}

	void showAccount(int accNo) {
		Account a = findAccount(accNo);
		if (a == null) {
			System.out.println("Account not found.");
		} else {
			a.displaySummary();
		}
	}

	void applyMonthlyInterestToAll() {
		for (int i = 0; i < accountCount; i++) {
			accounts[i].applyMonthlyInterest(this);
		}
		System.out.println("Monthly interest applied to all accounts and logged.");
	}

	void monthPassedForSalaryAccounts() {
		for (int i = 0; i < accountCount; i++) {
			if (accounts[i] instanceof SalaryAccount) {
				((SalaryAccount) accounts[i]).monthPassed(this);
			}
		}
	}

	void endOfDayReport() {
		System.out.println("---- End of Day Transaction Report ----");
		if (transactionCount == 0) {
			System.out.println("No transactions today.");
			return;
		}
		for (int i = 0; i < transactionCount; i++) {
			System.out.println(transactions[i].format());
		}
		// Reset daily transactions after report (typical end-of-day)
		transactionCount = 0;
		System.out.println("End-of-day report generated and transaction log cleared.");
	}
}

// Controller: handles orchestration between view and model
class BankController {
	Bank bank;
	BankView view;

	BankController(Bank b, BankView v) {
		bank = b;
		view = v;
	}

	void createAccountMenu() {
		int accNo = view.askInt("Enter new account number: ");
		if (bank.findAccount(accNo) != null) {
			System.out.println("Account already exists with that number.");
			return;
		}
		String name = view.askString("Enter account holder name: ");
		view.showMessage("Choose account type: 1.Savings 2.Salary 3.Current 4.Loan");
		int type = view.askInt("Type: ");
		double initial = view.askDouble("Initial amount (for Loan enter loan principal): ");
		Account a = null;
		if (type == 1) {
			a = new SavingsAccount(accNo, name, initial);
		} else if (type == 2) {
			a = new SalaryAccount(accNo, name, initial);
		} else if (type == 3) {
			double limit = view.askDouble("Enter overdraft limit for Current account: ");
			a = new CurrentAccount(accNo, name, initial, limit);
		} else if (type == 4) {
			a = new LoanAccount(accNo, name, initial);
		} else {
			System.out.println("Invalid type. Aborting account creation.");
			return;
		}
		if (bank.addAccount(a)) {
			System.out.println("Account created successfully.");
		}
	}

	void depositMenu() {
		int accNo = view.askInt("Enter account number to deposit into: ");
		Account a = bank.findAccount(accNo);
		if (a == null) {
			System.out.println("Account not found.");
			return;
		}
		double amt = view.askDouble("Enter amount to deposit: ");
		a.deposit(amt, bank);
		System.out.println("Deposit successful.");
	}

	void withdrawMenu() {
		int accNo = view.askInt("Enter account number to withdraw from: ");
		Account a = bank.findAccount(accNo);
		if (a == null) {
			System.out.println("Account not found.");
			return;
		}
		double amt = view.askDouble("Enter amount to withdraw: ");
		boolean ok = a.withdraw(amt, bank);
		if (ok)
			System.out.println("Withdrawal successful.");
		else
			System.out.println("Withdrawal failed.");
	}

	void showAllAccounts() {
		bank.showAllAccounts();
	}

	void showAccount() {
		int accNo = view.askInt("Enter account number to view: ");
		bank.showAccount(accNo);
	}

	void applyMonthlyInterest() {
		bank.applyMonthlyInterestToAll();
	}

	void monthPassed() {
		bank.monthPassedForSalaryAccounts();
		System.out.println("One month simulated. Salary inactivity counters updated.");
	}

	void endOfDayReport() {
		bank.endOfDayReport();
	}
}

// View: console based
class BankView {
	Scanner scanner = new Scanner(System.in);

	int askInt(String prompt) {
		System.out.print(prompt);
		while (!scanner.hasNextInt()) {
			System.out.print("Please enter a valid integer: ");
			scanner.next();
		}
		int val = scanner.nextInt();
		scanner.nextLine(); // consume newline
		return val;
	}

	double askDouble(String prompt) {
		System.out.print(prompt);
		while (!scanner.hasNextDouble()) {
			System.out.print("Please enter a valid number: ");
			scanner.next();
		}
		double val = scanner.nextDouble();
		scanner.nextLine();
		return val;
	}

	String askString(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine();
	}

	void showMenu() {
		System.out.println("\n=== XYZ Bank - Branch Automation ===");
		System.out.println("1. Create Account");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Show All Accounts");
		System.out.println("5. Show Account Details");
		System.out.println("6. Apply Monthly Interest (run monthly)");
		System.out.println("7. Simulate Month Passing (for Salary inactivity)");
		System.out.println("8. End of Day Report (daily transactions)");
		System.out.println("9. Exit");
	}

	void showMessage(String msg) {
		System.out.println(msg);
	}

	void close() {
		scanner.close();
	}
}

// Main application tying MVC together
class TestBank {
	public static void main(String[] args) {
		Bank model = new Bank();
		BankView view = new BankView();
		BankController controller = new BankController(model, view);

		boolean running = true;
		while (running) {
			view.showMenu();
			int choice = view.askInt("Choose option: ");
			switch (choice) {
			case 1:
				controller.createAccountMenu();
				break;
			case 2:
				controller.depositMenu();
				break;
			case 3:
				controller.withdrawMenu();
				break;
			case 4:
				controller.showAllAccounts();
				break;
			case 5:
				controller.showAccount();
				break;
			case 6:
				controller.applyMonthlyInterest();
				break;
			case 7:
				controller.monthPassed();
				break;
			case 8:
				controller.endOfDayReport();
				break;
			case 9:
				running = false;
				break;
			default:
				System.out.println("Invalid option. Try again.");
			}
		}

		view.showMessage("Exiting XYZ Bank application. Goodbye!");
		view.close();
	}
}
