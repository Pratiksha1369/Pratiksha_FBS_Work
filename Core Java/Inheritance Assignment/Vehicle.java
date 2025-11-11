class Vehicle {
	int id;
	String name;
	double price;
	static int count = 0;

	// default constructor
	Vehicle() {
		System.out.println("Vehicle default constructor");
		id = 0;
		name = "Not Given";
		price = 100000;
		count++;
	}

	// parameterized constructor
	Vehicle(int id, String name, double price) {
		System.out.println("Vehicle parameterized constructor");
		this.id = id;
		this.name = name;
		this.price = price;
		count++;
	}

	
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

	double getPrice() {
		return price;
	}

	void setPrice(double price) {
		this.price = price;
	}

	static int getCount() {
		return count;
	}

	static void setCount(int count) {
		Vehicle.count = count;
	}

	void display() {
		System.out.println("Vehicle ID: " + this.id);
		System.out.println("Vehicle Name: " + this.name);
		System.out.println("Price: " + this.price);
	}
}// class Vehicle ends here


class Car extends Vehicle {
	String fuelType;
	int seatingCapacity;

	Car() {
		super();
		fuelType = "Petrol";
		seatingCapacity = 5;
		System.out.println("Car default constructor");
	}

	Car(int id, String name, double price, String fuelType, int seatingCapacity) {
		super(id, name, price);
		this.fuelType = fuelType;
		this.seatingCapacity = seatingCapacity;
		System.out.println("Car parameterized constructor");
	}
	
	String getFuelType() {
		return fuelType;
	}

	void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	int getSeatingCapacity() {
		return seatingCapacity;
	}

	void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	void display() {
		super.display();
		System.out.println("Fuel Type: " + this.fuelType);
		System.out.println("Seating Capacity: " + this.seatingCapacity);
	}
}// class Car ends here


class Bus extends Vehicle {
	int routeNo;
	int capacity;

	Bus() {
		super();
		routeNo = 101;
		capacity = 40;
		System.out.println("Bus default constructor");
	}

	Bus(int id, String name, double price, int routeNo, int capacity) {
		super(id, name, price);
		this.routeNo = routeNo;
		this.capacity = capacity;
		System.out.println("Bus parameterized constructor");
	}

	int getRouteNo() {
		return routeNo;
	}

	void setRouteNo(int routeNo) {
		this.routeNo = routeNo;
	}

	int getCapacity() {
		return capacity;
	}

	void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	void display() {
		super.display();
		System.out.println("Route Number: " + this.routeNo);
		System.out.println("Passenger Capacity: " + this.capacity);
	}
}// class Bus ends here

class VehicleInheritance {
	public static void main(String[] args) {

		Car c1 = new Car();
		c1.display();
		System.out.println("\n");

		Car c2 = new Car(101, "Honda City", 1200000, "Diesel", 5);
		c2.display();

		System.out.println("\n\n");

		Bus b1 = new Bus();
		b1.display();

		System.out.println("\n");

		Bus b2 = new Bus(202, "Volvo", 2500000, 501, 50);
		b2.display();

		System.out.println("\n");
		System.out.println("\nTotal Vehicles: " + Vehicle.getCount());
	}
}