class Hospital {
    String name;
    String city;
    int numberOfDoctors;
    int emergencyBeds;

    void setName(String name) {
        this.name = name;
    }

    void setCity(String city) {
        this.city = city;
    }

    void setNumberOfDoctors(int numberOfDoctors) {
        this.numberOfDoctors = numberOfDoctors;
    }

    void setEmergencyBeds(int emergencyBeds) {
        this.emergencyBeds = emergencyBeds;
    }
} //Hospital ends here

class HospitalTest {
    public static void main(String[] args) {
        Hospital h1;
        h1 = new Hospital();
        h1.setName("Apollo Hospital");
        h1.setCity("Chennai");
        h1.setNumberOfDoctors(250);
        h1.setEmergencyBeds(50);

        System.out.println("Name: " + h1.name);
        System.out.println("City: " + h1.city);
        System.out.println("Number of Doctors: " + h1.numberOfDoctors);
        System.out.println("Emergency Beds: " + h1.emergencyBeds);
    } //main ends here
} //HospitalTest ends here
