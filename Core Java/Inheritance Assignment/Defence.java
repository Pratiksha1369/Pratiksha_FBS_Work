class Defence {
	String countryName;
	String headName;
	int manPowerCount;
	int noOfTroops;
	double budget;
	int noOfDepartments;
	int noOfVehicles;
	String locationOfHQ;
	int noOfMissionsPerformed;
	int noOfCasualties;
	static int count = 0;

	// Default constructor
	Defence() {
		System.out.println("Defence default constructor");
		countryName = "Not Given";
		headName = "Not Given";
		manPowerCount = 10000;
		noOfTroops = 5000;
		budget = 5000000;
		noOfDepartments = 5;
		noOfVehicles = 100;
		locationOfHQ = "Capital City";
		noOfMissionsPerformed = 10;
		noOfCasualties = 50;
		count++;
	}

	// Parameterized constructor
	Defence(String countryName, String headName, int manPowerCount, int noOfTroops, double budget,
			int noOfDepartments, int noOfVehicles, String locationOfHQ, int noOfMissionsPerformed,
			int noOfCasualties) {
		System.out.println("Defence parameterized constructor");
		this.countryName = countryName;
		this.headName = headName;
		this.manPowerCount = manPowerCount;
		this.noOfTroops = noOfTroops;
		this.budget = budget;
		this.noOfDepartments = noOfDepartments;
		this.noOfVehicles = noOfVehicles;
		this.locationOfHQ = locationOfHQ;
		this.noOfMissionsPerformed = noOfMissionsPerformed;
		this.noOfCasualties = noOfCasualties;
		count++;
	}

	void display() {
		System.out.println("Country Name: " + countryName);
		System.out.println("Head Name: " + headName);
		System.out.println("Man Power Count: " + manPowerCount);
		System.out.println("No. of Troops: " + noOfTroops);
		System.out.println("Budget: " + budget);
		System.out.println("No. of Departments: " + noOfDepartments);
		System.out.println("No. of Vehicles: " + noOfVehicles);
		System.out.println("Location of HQ: " + locationOfHQ);
		System.out.println("No. of Missions Performed: " + noOfMissionsPerformed);
		System.out.println("No. of Casualties: " + noOfCasualties);
	}

	static int getCount() {
		return count;
	}
}

// Army subclass
class Army extends Defence {
	int noOfTanks;
	int noOfGuns;
	int noOfGrenades;
	int noOfBattalions;

	Army() {
		super();
		noOfTanks = 50;
		noOfGuns = 500;
		noOfGrenades = 200;
		noOfBattalions = 10;
		System.out.println("Army default constructor");
	}

	Army(String countryName, String headName, int manPowerCount, int noOfTroops, double budget,
			int noOfDepartments, int noOfVehicles, String locationOfHQ, int noOfMissionsPerformed,
			int noOfCasualties, int noOfTanks, int noOfGuns, int noOfGrenades, int noOfBattalions) {
		super(countryName, headName, manPowerCount, noOfTroops, budget, noOfDepartments, noOfVehicles,
				locationOfHQ, noOfMissionsPerformed, noOfCasualties);
		this.noOfTanks = noOfTanks;
		this.noOfGuns = noOfGuns;
		this.noOfGrenades = noOfGrenades;
		this.noOfBattalions = noOfBattalions;
		System.out.println("Army parameterized constructor");
	}

	void display() {
		super.display();
		System.out.println("No. of Tanks: " + noOfTanks);
		System.out.println("No. of Guns: " + noOfGuns);
		System.out.println("No. of Grenades: " + noOfGrenades);
		System.out.println("No. of Battalions: " + noOfBattalions);
	}
}

// Navy subclass
class Navy extends Defence {
	int noOfShips;
	int noOfSubmarines;
	int noOfTorpedoes;

	Navy() {
		super();
		noOfShips = 20;
		noOfSubmarines = 5;
		noOfTorpedoes = 100;
		System.out.println("Navy default constructor");
	}

	Navy(String countryName, String headName, int manPowerCount, int noOfTroops, double budget,
			int noOfDepartments, int noOfVehicles, String locationOfHQ, int noOfMissionsPerformed,
			int noOfCasualties, int noOfShips, int noOfSubmarines, int noOfTorpedoes) {
		super(countryName, headName, manPowerCount, noOfTroops, budget, noOfDepartments, noOfVehicles,
				locationOfHQ, noOfMissionsPerformed, noOfCasualties);
		this.noOfShips = noOfShips;
		this.noOfSubmarines = noOfSubmarines;
		this.noOfTorpedoes = noOfTorpedoes;
		System.out.println("Navy parameterized constructor");
	}

	void display() {
		super.display();
		System.out.println("No. of Ships: " + noOfShips);
		System.out.println("No. of Submarines: " + noOfSubmarines);
		System.out.println("No. of Torpedoes: " + noOfTorpedoes);
	}
}

// AirForce subclass
class AirForce extends Defence {
	int noOfMissiles;
	int noOfAircrafts;
	int noOfSquadrons;

	AirForce() {
		super();
		noOfMissiles = 200;
		noOfAircrafts = 50;
		noOfSquadrons = 8;
		System.out.println("AirForce default constructor");
	}

	AirForce(String countryName, String headName, int manPowerCount, int noOfTroops, double budget,
			int noOfDepartments, int noOfVehicles, String locationOfHQ, int noOfMissionsPerformed,
			int noOfCasualties, int noOfMissiles, int noOfAircrafts, int noOfSquadrons) {
		super(countryName, headName, manPowerCount, noOfTroops, budget, noOfDepartments, noOfVehicles,
				locationOfHQ, noOfMissionsPerformed, noOfCasualties);
		this.noOfMissiles = noOfMissiles;
		this.noOfAircrafts = noOfAircrafts;
		this.noOfSquadrons = noOfSquadrons;
		System.out.println("AirForce parameterized constructor");
	}

	void display() {
		super.display();
		System.out.println("No. of Missiles: " + noOfMissiles);
		System.out.println("No. of Aircrafts: " + noOfAircrafts);
		System.out.println("No. of Squadrons: " + noOfSquadrons);
	}
}


class DefenceInheritance {
	public static void main(String[] args) {
		Army a1 = new Army();
		a1.display();

		System.out.println("\n");

		Army a2 = new Army("India", "General Arjun", 100000, 70000, 8000000, 8, 500, "Delhi", 30, 200, 300, 1000, 400, 20);
		a2.display();

		System.out.println("\n");

		Navy n1 = new Navy();
		n1.display();

		System.out.println("\n");

		AirForce af1 = new AirForce("India", "Marshal Rajiv", 80000, 40000, 9000000, 6, 300, "Bangalore", 25, 100, 500, 100, 12);
		af1.display();

		System.out.println("\nTotal Defence Branches Created: " + Defence.getCount());
	}
}
