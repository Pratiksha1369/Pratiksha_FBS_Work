class Restaurant {
    String name;
    String location;
    int seatingCapacity;
    double rating;

    void setName(String name) {
        this.name = name;
    }

    void setLocation(String location) {
        this.location = location;
    }

    void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    void setRating(double rating) {
        this.rating = rating;
    }
} //Restaurant ends here

class RestaurantTest {
    public static void main(String[] args) {
        Restaurant r1;
        r1 = new Restaurant();
        r1.setName("Spice Garden");
        r1.setLocation("Bangalore");
        r1.setSeatingCapacity(120);
        r1.setRating(4.5);

        System.out.println("Name: " + r1.name);
        System.out.println("Location: " + r1.location);
        System.out.println("Seating Capacity: " + r1.seatingCapacity);
        System.out.println("Rating: " + r1.rating);
    } //main ends here
} //RestaurantTest ends here
