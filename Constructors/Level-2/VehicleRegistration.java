public class VehicleRegistration {
    private String ownerName;
    private String vehicleType;
    private static double registrationFee;

    public VehicleRegistration(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: $" + registrationFee);
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        VehicleRegistration vehicle1 = new VehicleRegistration("John Doe", "Sedan");
        VehicleRegistration.updateRegistrationFee(200.0);
        vehicle1.displayVehicleDetails();

        VehicleRegistration vehicle2 = new VehicleRegistration("Jane Doe", "SUV");
        vehicle2.displayVehicleDetails();
    }
}