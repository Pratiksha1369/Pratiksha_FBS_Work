class HotelRoom {
    int roomNumber;
    String roomType;
    double pricePerNight;
    boolean isAvailable;

    void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
} //HotelRoom ends here

class HotelRoomTest {
    public static void main(String[] args) {
        HotelRoom hr1;
        hr1 = new HotelRoom();
        hr1.setRoomNumber(304);
        hr1.setRoomType("Deluxe");
        hr1.setPricePerNight(3500);
        hr1.setIsAvailable(true);

        System.out.println("Room Number: " + hr1.roomNumber);
        System.out.println("Room Type: " + hr1.roomType);
        System.out.println("Price per Night: " + hr1.pricePerNight);
        System.out.println("Available: " + hr1.isAvailable);
    } //main ends here
} //HotelRoomTest ends here
