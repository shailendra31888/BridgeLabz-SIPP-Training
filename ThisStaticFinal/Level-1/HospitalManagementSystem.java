public class HospitalManagementSystem {
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;
    private final String patientID;
    private String name;
    private int age;
    private String ailment;

    public HospitalManagementSystem(String name, int age, String ailment, String patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    public static int getTotalPatients() {
        return totalPatients;
    }

    public void displayDetails() {
        if (this instanceof HospitalManagementSystem) {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
            System.out.println("Patient ID: " + patientID);
        }
    }

    public static void main(String[] args) {
        HospitalManagementSystem patient1 = new HospitalManagementSystem("Alice", 30, "Flu", "P001");
        patient1.displayDetails();
        HospitalManagementSystem patient2 = new HospitalManagementSystem("Bob", 40, "Cold", "P002");
        patient2.displayDetails();
        System.out.println("Total Patients: " + getTotalPatients());
    }
}