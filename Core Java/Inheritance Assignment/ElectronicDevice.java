class ElectronicDevice {
	int id;
	String name;
	double price;
	static int count = 0;

	// default constructor
	ElectronicDevice() {
		System.out.println("ElectronicDevice default constructor");
		id = 0;
		name = "Not Given";
		price = 10000;
		count++;
	}

	// parameterized constructor
	ElectronicDevice(int id, String name, double price) {
		System.out.println("ElectronicDevice parameterized constructor");
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
		ElectronicDevice.count = count;
	}

	void display() {
		System.out.println("Device ID: " + this.id);
		System.out.println("Device Name: " + this.name);
		System.out.println("Price: " + this.price);
	}
}// class ElectronicDevice ends here


class Mobile extends ElectronicDevice {
	String brand;
	int storage;

	Mobile() {
		super();
		brand = "Generic";
		storage = 64;
		System.out.println("Mobile default constructor");
	}

	Mobile(int id, String name, double price, String brand, int storage) {
		super(id, name, price);
		this.brand = brand;
		this.storage = storage;
		System.out.println("Mobile parameterized constructor");
	}

	String getBrand() {
		return brand;
	}

	void setBrand(String brand) {
		this.brand = brand;
	}

	int getStorage() {
		return storage;
	}

	void setStorage(int storage) {
		this.storage = storage;
	}

	void display() {
		super.display();
		System.out.println("Brand: " + this.brand);
		System.out.println("Storage: " + this.storage + " GB");
	}
}// class Mobile ends here


class Laptop extends ElectronicDevice {
	String processor;
	int ram;

	Laptop() {
		super();
		processor = "i5";
		ram = 8;
		System.out.println("Laptop default constructor");
	}

	Laptop(int id, String name, double price, String processor, int ram) {
		super(id, name, price);
		this.processor = processor;
		this.ram = ram;
		System.out.println("Laptop parameterized constructor");
	}

	String getProcessor() {
		return processor;
	}

	void setProcessor(String processor) {
		this.processor = processor;
	}

	int getRam() {
		return ram;
	}

	void setRam(int ram) {
		this.ram = ram;
	}

	void display() {
		super.display();
		System.out.println("Processor: " + this.processor);
		System.out.println("RAM: " + this.ram + " GB");
	}
}// class Laptop ends here


class Television extends ElectronicDevice {
	double screenSize;
	String type;

	Television() {
		super();
		screenSize = 42.0;
		type = "LED";
		System.out.println("Television default constructor");
	}

	Television(int id, String name, double price, double screenSize, String type) {
		super(id, name, price);
		this.screenSize = screenSize;
		this.type = type;
		System.out.println("Television parameterized constructor");
	}

	double getScreenSize() {
		return screenSize;
	}

	void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	String getType() {
		return type;
	}

	void setType(String type) {
		this.type = type;
	}

	void display() {
		super.display();
		System.out.println("Screen Size: " + this.screenSize + " inches");
		System.out.println("Type: " + this.type);
	}
}// class Television ends here


class ElectronicDeviceInheritance {
	public static void main(String[] args) {

		Mobile m1 = new Mobile();
		m1.display();
		System.out.println("\n");

		Mobile m2 = new Mobile(101, "iPhone 15", 120000, "Apple", 256);
		m2.display();

		System.out.println("\n\n");

		Laptop l1 = new Laptop();
		l1.display();
		System.out.println("\n");

		Laptop l2 = new Laptop(202, "Dell Inspiron", 80000, "i7", 16);
		l2.display();

		System.out.println("\n\n");

		Television t1 = new Television();
		t1.display();
		System.out.println("\n");

		Television t2 = new Television(303, "Samsung Smart TV", 65000, 55, "OLED");
		t2.display();

		System.out.println("\nTotal Devices: " + ElectronicDevice.getCount());
	}
}
