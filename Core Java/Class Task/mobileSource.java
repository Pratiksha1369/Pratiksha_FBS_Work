class Mobile {
    String brand;
    String model;
    int storage;
    double price;

    void setBrand(String brand) {
        this.brand = brand;
    }

    void setModel(String model) {
        this.model = model;
    }

    void setStorage(int storage) {
        this.storage = storage;
    }

    void setPrice(double price) {
        this.price = price;
    }
} //Mobile ends here

class MobileTest {
    public static void main(String[] args) {
        Mobile m1;
        m1 = new Mobile();
        m1.setBrand("Samsung");
        m1.setModel("Galaxy S23");
        m1.setStorage(256);
        m1.setPrice(95000);

        System.out.println("Brand: " + m1.brand);
        System.out.println("Model: " + m1.model);
        System.out.println("Storage: " + m1.storage + " GB");
        System.out.println("Price: " + m1.price);
    } //main ends here
} //MobileTest ends here
