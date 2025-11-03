class Flight {
    String flightName;
    String departure;
    String destination;
    double ticketPrice;

    void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    void setDeparture(String departure) {
        this.departure = departure;
    }

    void setDestination(String destination) {
        this.destination = destination;
    }

    void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
} //Flight ends here

class FlightTest {
    public static void main(String[] args) {
        Flight f1;
        f1 = new Flight();
        f1.setFlightName("Air India 302");
        f1.setDeparture("Delhi");
        f1.setDestination("Mumbai");
        f1.setTicketPrice(5500);

        System.out.println("Flight Name: " + f1.flightName);
        System.out.println("Departure: " + f1.departure);
        System.out.println("Destination: " + f1.destination);
        System.out.println("Ticket Price: " + f1.ticketPrice);
    } //main ends here
} //FlightTest ends here
