public class Vehicle {
    private static double registrationFee = 100.0;
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
        }
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("John Doe", "Car", "V001");
        vehicle1.displayDetails();
        Vehicle vehicle2 = new Vehicle("Jane Smith", "Bike", "V002");
        vehicle2.displayDetails();
    }
}