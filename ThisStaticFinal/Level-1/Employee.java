public class Employee {
    private static String companyName = "Tech Corp";
    private static int totalEmployees = 0;
    private final int id;
    private String name;
    private String designation;

    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
        this.id = ++totalEmployees;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayDetails() {
        if (this instanceof Employee) {
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Designation: " + designation);
        }
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("John Doe", "Developer");
        emp1.displayDetails();
        Employee emp2 = new Employee("Jane Smith", "Manager");
        emp2.displayDetails();
        displayTotalEmployees();
    }
}