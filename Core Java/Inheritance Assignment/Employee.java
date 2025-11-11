class Employee {
	int id;
	String name;
	double salary;
	static int count = 0;


	// default constructor
	Employee() {
		System.out.println("Employee default constructor");
		id = 0;
		name = "Not Given";
		salary = 10000;
		count++;
	}// default ends

	Employee(int id, String name, double salary) {
		System.out.println("Employee parameterized constructor");
		this.id = id;
		this.name = name;
		this.salary = salary;
		count++;
	}// parameterised ends

	
	int getId() {
		return id;
	}

	void setId(int id) {
		this.id = id;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	double getSalary() {
		return salary;
	}

	void setSalary(double salary) {
		this.salary = salary;
	}

	static int getCount() {
		return count;
	}

	static void setCount(int count) {
		Employee.count = count;
	}

	void display() {
		System.out.println("Id: " + this.id);
		System.out.println("Name: " + this.name);
		System.out.println("Salary: " + this.salary);
	}

}// class employee ends here

class HR extends Employee {
	double commission;


	 HR() {
		 super(); // calls Employee default constructor
			commission = 2000;
			System.out.println("HR default constructor");
	}

	 HR(int id, String name, double salary, double commission) {
			super(id, name, salary);
			this.commission = commission;
			System.out.println("HR parameterized constructor");
	}

	
	double getCommission() {
		return commission;
	}

	 void setCommission(double commission) {
		 this.commission = commission;
	 }

	// Display function
	 void display() {
			super.display();
			System.out.println("Commission: " + this.commission);
		}	
}//class Hr ends here

class SalesManager extends Employee {
	double incentives;
	int target;

	SalesManager() {
		super();
		incentives = 1500;
		target = 10;
		System.out.println("SalesManager default constructor");
	}

	SalesManager(int id, String name, double salary, double incentives, int target) {
		super(id, name, salary);
		this.incentives = incentives;
		this.target = target;
		System.out.println("SalesManager parameterized constructor");
	}
	
	

	double getIncentives() {
		return incentives;
	}

	void setIncentives(double incentives) {
		this.incentives = incentives;
	}

	int getTarget() {
		return target;
	}

	void setTarget(int target) {
		this.target = target;
	}

	// Display function
	void display() {
		super.display();
		System.out.println("Incentives: " + this.incentives);
		System.out.println("Target: " + this.target);
	}
}//salesmaanger ends here

class Admin extends Employee {
	double allowance;

	Admin() {
		super();
		allowance = 3000;
		System.out.println("Admin default constructor");
	}

	Admin(int id, String name, double salary, double allowance) {
		super(id, name, salary);
		this.allowance = allowance;
		System.out.println("Admin parameterized constructor");
	}
	
	double getAllowance() {
		return allowance;
	}

	void setAllowance(double allowance) {
		this.allowance = allowance;
	}

	void display() {
		super.display();
		System.out.println("Allowance: " + this.allowance);
	}
}

class EmployeeInheritance {
	public static void main(String[] args) {

		HR hr1 = new HR();
		hr1.display();

		HR hr2 = new HR(101, "Sonia", 45000, 5000);
		hr2.display();
		
		System.out.println("\n");

		SalesManager s1 = new SalesManager();
		s1.display();

		SalesManager s2 = new SalesManager(202, "Ravi", 55000, 8000, 15);
		s2.display();
		
		System.out.println("\n");
		Admin a1 = new Admin();
		a1.display();
		
		Admin a2 = new Admin(303, "Priya", 60000, 9000);
		a2.display();

		System.out.println("\nTotal Employees: " + Employee.getCount());
	}
}