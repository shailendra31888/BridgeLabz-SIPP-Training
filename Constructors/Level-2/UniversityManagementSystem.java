public class UniversityManagementSystem{
    public int rollNumber;
    protected String name;
    private double CGPA;

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public static void main(String[] args) {
        UniversityManagementSystem student = new UniversityManagementSystem();
        student.rollNumber = 101;
        student.name = "Alice";
        student.setCGPA(3.8);
        System.out.println("Roll Number: " + student.rollNumber);
        System.out.println("Name: " + student.name);
        System.out.println("CGPA: " + student.getCGPA());
    }
}

class PostgraduateStudent extends UniversityManagementSystem {
    public void displayPostgraduateDetails() {
        System.out.println("Postgraduate Student Details:");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + getCGPA());
    }
}