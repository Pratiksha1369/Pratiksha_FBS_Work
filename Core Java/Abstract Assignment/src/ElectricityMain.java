
import java.util.Scanner;
abstract class ElectricityBill {
    int units;
    String customerName;

	//default constucotr
    ElectricityBill(){
    	this.units=0;
    	this.customerName="NO Name";
    }
    
    //parameterise constructor
    ElectricityBill(int units,String customerName){
    	this.units=units;
    	this.customerName=customerName;
    }
    
    //getters and setters
    
    int getUnits() {
    	return units;
    }
    
    void setUnits(int units) {
    	this.units=units;
    }
    
    String getName() {
    	return customerName;
    }
    
    void setName(String customerName) {
    	this.customerName=customerName;
    }
    
    // Display
    void display() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Units Consumed: " + units);
    }
    
 // TOSTRING
    public String toString() {
        return "Customer Name: " + customerName +
               "\nUnits: " + units;
    }
    
    
    // ABSTRACT
    abstract double calculateBill();
    
 // FINAL METHOD (DO NOT OVERRIDE)
    final void generateBill() {
        double bill = calculateBill();
        double tax = bill * 0.05;
        bill += tax + 50;

        System.out.println("\n");
        System.out.println(this.toString());
        System.out.println("Base Bill: " + calculateBill());
        System.out.println("Tax (5%): " + tax);
        System.out.println("Fixed Charge: 50");
        System.out.println("Total Bill: " + bill);
    }
}

class ResidentialBill extends ElectricityBill {

    // DEFAULT CONSTRUCTOR
    ResidentialBill() {
        super();
    }

    // PARAMETERIZED CONSTRUCTOR
    ResidentialBill(String name, int units) {
        super(units, name);
    }

    @Override
    double calculateBill() {
        int units = getUnits();
        double amount = 0;

        if (units <= 100)
            amount = units * 2.5;
        else if (units <= 300)
            amount = (100 * 2.5) + (units - 100) * 3.5;
        else
            amount = (100 * 2.5) + (200 * 3.5) + (units - 300) * 5;

        if (units > 500)
            amount += 150;

        return amount;
    }

}

class CommercialBill extends ElectricityBill {

    // DEFAULT CONSTRUCTOR
    CommercialBill() {
        super();
    }

    // PARAMETERIZED CONSTRUCTOR
    CommercialBill(String name, int units) {
        super(units, name);
    }

    @Override
    double calculateBill() {
        int units = getUnits();
        double amount = units * 6.5;

        if (units < 200)
            amount = 1500;

        if (units > 1000)
            amount += amount * 0.08;

        return amount;
    }

    // TOSTRING
    public String toString() {
        return "Commercial Customer\n" + super.toString();
    }
}


public class ElectricityMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Residential Bill");
        System.out.println("2. Commercial Bill");
        System.out.print("Choose customer type: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter units consumed: ");
        int units = sc.nextInt();

        ElectricityBill bill = null;

        if (choice == 1) {
            bill = new ResidentialBill(name, units);
        } else if (choice == 2) {
            bill = new CommercialBill(name, units);
        } else {
            System.out.println("Invalid choice!");
            return;
        }

        bill.generateBill();
    }
}


