class Laptop {
    String brand;
    String processor;
    int ram;
    double price;

    void setBrand(String brand) {
        this.brand = brand;
    }

    void setProcessor(String processor) {
        this.processor = processor;
    }

    void setRam(int ram) {
        this.ram = ram;
    }

    void setPrice(double price) {
        this.price = price;
    }
} //Laptop ends here

class LaptopTest {
    public static void main(String[] args) {
        Laptop l1;
        l1 = new Laptop();
        l1.setBrand("Dell");
        l1.setProcessor("Intel i7");
        l1.setRam(16);
        l1.setPrice(82000);

        System.out.println("Brand: " + l1.brand);
        System.out.println("Processor: " + l1.processor);
        System.out.println("RAM: " + l1.ram + " GB");
        System.out.println("Price: " + l1.price);
    } //main ends here
} //LaptopTest ends here
