class Car {
    String brand;
    String model;
    int year;
    double price;

    void setBrand(String brand) {
        this.brand = brand;
    }

    void setModel(String model) {
        this.model = model;
    }

    void setYear(int year) {
        this.year = year;
    }

    void setPrice(double price) {
        this.price = price;
    }
}//car ends here

class CarTest {
    public static void main(String[] args) {
        Car c1;
        c1 = new Car();
        c1.setBrand("Toyota");
        c1.setModel("Corolla");
        c1.setYear(2020);
        c1.setPrice(1800000);

        System.out.println("Brand: " + c1.brand);
        System.out.println("Model: " + c1.model);
        System.out.println("Year: " + c1.year);
        System.out.println("Price: " + c1.price);
    }//main ends here
}//carTest ends here
