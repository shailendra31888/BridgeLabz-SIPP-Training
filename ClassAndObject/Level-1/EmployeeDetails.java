public class EmployeeDetails{
    String name;
    int id;
    double salary;

    public EmployeeDetails(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: " + salary);
    }

    public static void main(String[] args) {
        EmployeeDetails emp = new EmployeeDetails("John Doe", 101, 50000);
        emp.displayDetails();
    }
}