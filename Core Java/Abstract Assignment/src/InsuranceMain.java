import java.util.Scanner;

abstract class InsurancePolicy {
    String policyHolderName;
    double basePremium;
    
    //default constructor
    InsurancePolicy(){
    	this.policyHolderName="Unknown";
    	this.basePremium=00;
    }
    
    //parameterise
    InsurancePolicy(String policyHolderName, double basePremium) {
		this.policyHolderName = policyHolderName;
		this.basePremium = basePremium;
	}
    
  //sttters and getters
	String getPolicyHolderName() {
		return policyHolderName;
	}

	void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}

	double getBasePremium() {
		return basePremium;
	}

	void setBasePremium(double basePremium) {
		this.basePremium = basePremium;
	}

    
	// ABSTRACT METHOD
    abstract double calculatePremium();
    
  //toString

  	@Override
  	public String toString() {
  		return "InsurancePolicy policyHolderName= " + policyHolderName + ", basePremium= " + basePremium;
  	}
  	
  	//display
  	 void display() {
         System.out.println("\n========== POLICY DETAILS ==========");
         System.out.println(this.toString());
         System.out.println("Final Premium: " + calculatePremium());
//         System.out.println("====================================\n");
  	 }
  }//insurance policy ends here
	
class CarInsurance extends InsurancePolicy {
    private int carAgeInYears;
    private boolean hadAccidentInLastYear;
    private double carValue;

    // DEFAULT CONSTRUCTOR
    CarInsurance() {
        super();
        this.carAgeInYears = 0;
        this.hadAccidentInLastYear = false;
        this.carValue = 0.0;
    }

    // PARAMETERIZED CONSTRUCTOR
    CarInsurance(String name, double basePremium, int carAgeInYears, boolean accident, double carValue) {
        super(name, basePremium);
        this.carAgeInYears = carAgeInYears;
        this.hadAccidentInLastYear = accident;
        this.carValue = carValue;
    }

    // GETTERS & SETTERS
     int getCarAgeInYears() { return carAgeInYears; }
     void setCarAgeInYears(int carAgeInYears) { this.carAgeInYears = carAgeInYears; }

     boolean isHadAccidentInLastYear() { return hadAccidentInLastYear; }
     void setHadAccidentInLastYear(boolean hadAccidentInLastYear) { this.hadAccidentInLastYear = hadAccidentInLastYear; }

     double getCarValue() { return carValue; }
     void setCarValue(double carValue) { this.carValue = carValue; }

    // CALCULATE PREMIUM
    @Override
    double calculatePremium() {
        double premium = getBasePremium();

        // AGE-BASED CHARGES
        if (carAgeInYears <= 3) premium += getBasePremium() * 0.10;
        else if (carAgeInYears <= 7) premium += getBasePremium() * 0.20;
        else premium += getBasePremium() * 0.30;

        // ACCIDENT LOADING / DISCOUNT
        if (hadAccidentInLastYear) premium += premium * 0.25;
        else premium -= premium * 0.10;

        // HIGH VALUE CAR EXTRA CHARGE
        if (carValue > 1000000) premium += 2000;

        return premium;
    }

    // TOSTRING
    public String toString() {
        return "Car Insurance\n" + super.toString() +
               "\nCar Age: " + carAgeInYears +
               "\nHad Accident Last Year: " + hadAccidentInLastYear +
               "\nCar Value: " + carValue;
    }
}

class HealthInsurance extends InsurancePolicy {
    private int age;
    private boolean isSmoker;
    private boolean hasPreExistingDisease;

    // DEFAULT CONSTRUCTOR
    HealthInsurance() {
        super();
        this.age = 0;
        this.isSmoker = false;
        this.hasPreExistingDisease = false;
    }

    // PARAMETERIZED CONSTRUCTOR
    HealthInsurance(String name, double basePremium, int age, boolean isSmoker, boolean hasDisease) {
        super(name, basePremium);
        this.age = age;
        this.isSmoker = isSmoker;
        this.hasPreExistingDisease = hasDisease;
    }

    // GETTERS & SETTERS
     int getAge() { return age; }
     void setAge(int age) { this.age = age; }

     boolean isSmoker() { return isSmoker; }
     void setSmoker(boolean smoker) { isSmoker = smoker; }

     boolean isHasPreExistingDisease() { return hasPreExistingDisease; }
     void setHasPreExistingDisease(boolean hasPreExistingDisease) { this.hasPreExistingDisease = hasPreExistingDisease; }

    // PREMIUM CALCULATION
    @Override
    double calculatePremium() {
        double premium = getBasePremium();

        // AGE-BASED CONDITIONS
        if (age < 30) premium += getBasePremium() * 0.10;
        else if (age <= 45) premium += getBasePremium() * 0.25;
        else premium += getBasePremium() * 0.40;

        // SMOKER / NON-SMOKER
        if (isSmoker) premium += premium * 0.30;
        else premium -= premium * 0.05;

        // PRE-EXISTING DISEASE
        if (hasPreExistingDisease) premium += getBasePremium() * 0.20;

        return premium;
    }

    // TOSTRING
    public String toString() {
        return "Health Insurance\n" + super.toString() +
               "\nAge: " + age +
               "\nSmoker: " + isSmoker +
               "\nPre-existing Disease: " + hasPreExistingDisease;
    }
}

public class InsuranceMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Car Insurance");
        System.out.println("2. Health Insurance");
        System.out.print("Choose: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Policy Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Base Premium: ");
        double base = sc.nextDouble();

        InsurancePolicy policy = null;

        if (choice == 1) {
            System.out.print("Car Age (years): ");
            int age = sc.nextInt();
            System.out.print("Had accident last year (true/false): ");
            boolean accident = sc.nextBoolean();
            System.out.print("Car Value: ");
            double value = sc.nextDouble();

            policy = new CarInsurance(name, base, age, accident, value);

        } else if (choice == 2) {
            System.out.print("Age: ");
            int age = sc.nextInt();
            System.out.print("Smoker (true/false): ");
            boolean smoker = sc.nextBoolean();
            System.out.print("Pre-existing disease (true/false): ");
            boolean disease = sc.nextBoolean();

            policy = new HealthInsurance(name, base, age, smoker, disease);
        } else {
            System.out.println("Invalid Option!");
            return;
        }

        policy.display();
    }
}

