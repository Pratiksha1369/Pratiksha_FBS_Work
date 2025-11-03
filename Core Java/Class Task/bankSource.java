class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;
    String accountType;

    void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    void setBalance(double balance) {
        this.balance = balance;
    }

    void setAccountType(String accountType) {
        this.accountType = accountType;
    }
} //BankAccount ends here

class BankAccountTest {
    public static void main(String[] args) {
        BankAccount b1;
        b1 = new BankAccount();
        b1.setAccountHolder("Rahul Sharma");
        b1.setAccountNumber(987654321);
        b1.setBalance(25000.75);
        b1.setAccountType("Savings");

        System.out.println("Account Holder: " + b1.accountHolder);
        System.out.println("Account Number: " + b1.accountNumber);
        System.out.println("Balance: " + b1.balance);
        System.out.println("Account Type: " + b1.accountType);
    } //main ends here
} //BankAccountTest ends here
