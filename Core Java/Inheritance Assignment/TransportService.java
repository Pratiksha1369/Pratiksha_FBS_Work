class TransportService {
    String serviceName;
    String city;
    int dailyUsers;
    static int count = 0;

    TransportService() {
        System.out.println("TransportService default constructor");
        serviceName = "Unknown";
        city = "Unknown";
        dailyUsers = 0;
        count++;
    }

    TransportService(String serviceName, String city, int dailyUsers) {
        System.out.println("TransportService parameterized constructor");
        this.serviceName = serviceName;
        this.city = city;
        this.dailyUsers = dailyUsers;
        count++;
    }

    void display() {
        System.out.println("Service Name: " + serviceName);
        System.out.println("City: " + city);
        System.out.println("Daily Users: " + dailyUsers);
    }

    static int getCount() {
        return count;
    }
}

// Bus subclass
class BusService extends TransportService {
    int buses;
    double ticketPrice;

    BusService() {
        super();
        buses = 100;
        ticketPrice = 10.0;
        System.out.println("BusService default constructor");
    }

    BusService(String serviceName, String city, int dailyUsers, int buses, double ticketPrice) {
        super(serviceName, city, dailyUsers);
        this.buses = buses;
        this.ticketPrice = ticketPrice;
        System.out.println("BusService parameterized constructor");
    }

    void display() {
        super.display();
        System.out.println("Buses Available: " + buses);
        System.out.println("Ticket Price: "+ ticketPrice);
    }
}

// Metro subclass
class MetroService extends TransportService {
    int stations;
    double avgSpeed;

    MetroService() {
        super();
        stations = 15;
        avgSpeed = 60.0;
        System.out.println("MetroService default constructor");
    }

    MetroService(String serviceName, String city, int dailyUsers, int stations, double avgSpeed) {
        super(serviceName, city, dailyUsers);
        this.stations = stations;
        this.avgSpeed = avgSpeed;
        System.out.println("MetroService parameterized constructor");
    }

    void display() {
        super.display();
        System.out.println("Stations: " + stations);
        System.out.println("Average Speed: " + avgSpeed + " km/h");
    }
}

// Cab subclass
class CabService extends TransportService {
    int cars;
    double baseFare;

    CabService() {
        super();
        cars = 50;
        baseFare = 40.0;
        System.out.println("CabService default constructor");
    }

    CabService(String serviceName, String city, int dailyUsers, int cars, double baseFare) {
        super(serviceName, city, dailyUsers);
        this.cars = cars;
        this.baseFare = baseFare;
        System.out.println("CabService parameterized constructor");
    }

    void display() {
        super.display();
        System.out.println("Cars Available: " + cars);
        System.out.println("Base Fare: "+ baseFare);
    }
}

class TransportInheritance {
    public static void main(String[] args) {
        BusService b1 = new BusService("CityLine", "Bangalore", 50000, 120, 15.0);
        b1.display();

        System.out.println("\n");

        MetroService m1 = new MetroService("Namma Metro", "Bangalore", 80000, 25, 70.0);
        m1.display();

        System.out.println("\n");

        CabService c1 = new CabService("QuickCab", "Bangalore", 20000, 500, 45.0);
        c1.display();

        System.out.println("\nTotal Transport Services: " + TransportService.getCount());
    }
}
