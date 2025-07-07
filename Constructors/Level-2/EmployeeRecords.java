public class EmployeeRecords {
    public int employeeID;
    protected String department;
    private double salary;

    public EmployeeRecords(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void modifySalary(double newSalary) {
        this.salary = newSalary;
    }

    public double getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        EmployeeRecords employee = new EmployeeRecords(101, "Engineering", 75000);
        System.out.println("Employee ID: " + employee.employeeID);
        System.out.println("Department: " + employee.department);
        System.out.println("Salary: $" + employee.getSalary());
        employee.modifySalary(80000);
        System.out.println("Updated Salary: $" + employee.getSalary());
    }
}