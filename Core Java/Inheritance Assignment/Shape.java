class Shape {
	int id;
	String name;
	double area;
	static int count = 0;

	// default constructor
	Shape() {
		System.out.println("Shape default constructor");
		id = 0;
		name = "Not Given";
		area = 0.0;
		count++;
	}

	// parameterized constructor
	Shape(int id, String name, double area) {
		System.out.println("Shape parameterized constructor");
		this.id = id;
		this.name = name;
		this.area = area;
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

	double getArea() {
		return area;
	}

	void setArea(double area) {
		this.area = area;
	}

	static int getCount() {
		return count;
	}

	static void setCount(int count) {
		Shape.count = count;
	}

	void display() {
		System.out.println("Shape ID: " + this.id);
		System.out.println("Shape Name: " + this.name);
		System.out.println("Area: " + this.area);
	}
}// class Shape ends here


class Rectangle extends Shape {
	double length;
	double breadth;

	Rectangle() {
		super();
		length = 10;
		breadth = 5;
		System.out.println("Rectangle default constructor");
	}

	Rectangle(int id, String name, double area, double length, double breadth) {
		super(id, name, area);
		this.length = length;
		this.breadth = breadth;
		System.out.println("Rectangle parameterized constructor");
	}

	double getLength() {
		return length;
	}

	void setLength(double length) {
		this.length = length;
	}

	double getBreadth() {
		return breadth;
	}

	void setBreadth(double breadth) {
		this.breadth = breadth;
	}

	void display() {
		super.display();
		System.out.println("Length: " + this.length);
		System.out.println("Breadth: " + this.breadth);
	}
}// class Rectangle ends here


class Triangle extends Shape {
	double base;
	double height;

	Triangle() {
		super();
		base = 8;
		height = 6;
		System.out.println("Triangle default constructor");
	}

	Triangle(int id, String name, double area, double base, double height) {
		super(id, name, area);
		this.base = base;
		this.height = height;
		System.out.println("Triangle parameterized constructor");
	}

	double getBase() {
		return base;
	}

	void setBase(double base) {
		this.base = base;
	}

	double getHeight() {
		return height;
	}

	void setHeight(double height) {
		this.height = height;
	}

	void display() {
		super.display();
		System.out.println("Base: " + this.base);
		System.out.println("Height: " + this.height);
	}
}// class Triangle ends here


class Square extends Shape {
	double side;

	Square() {
		super();
		side = 5;
		System.out.println("Square default constructor");
	}

	Square(int id, String name, double area, double side) {
		super(id, name, area);
		this.side = side;
		System.out.println("Square parameterized constructor");
	}

	double getSide() {
		return side;
	}

	void setSide(double side) {
		this.side = side;
	}

	void display() {
		super.display();
		System.out.println("Side: " + this.side);
	}
}// class Square ends here


class ShapeInheritance {
	public static void main(String[] args) {

		Rectangle r1 = new Rectangle();
		r1.display();
		System.out.println("\n");

		Rectangle r2 = new Rectangle(101, "Rectangle", 50.0, 10, 5);
		r2.display();

		System.out.println("\n\n");

		Triangle t1 = new Triangle();
		t1.display();
		System.out.println("\n");

		Triangle t2 = new Triangle(202, "Triangle", 30.0, 8, 6);
		t2.display();

		System.out.println("\n\n");

		Square s1 = new Square();
		s1.display();
		System.out.println("\n");

		Square s2 = new Square(303, "Square", 25.0, 5);
		s2.display();

		System.out.println("\nTotal Shapes: " + Shape.getCount());
	}
}
