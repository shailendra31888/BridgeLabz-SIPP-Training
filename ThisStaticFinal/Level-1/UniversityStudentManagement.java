public class UniversityStudentManagement {
    private static String universityName = "State University";
    private static int totalStudents = 0;
    private final String rollNumber;
    private String name;
    private String grade;

    public UniversityStudentManagement(String name, String grade, String rollNumber) {
        this.name = name;
        this.grade = grade;
        this.rollNumber = rollNumber;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    public void displayDetails() {
        if (this instanceof UniversityStudentManagement) {
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade);
        }
    }

    public static void main(String[] args) {
        UniversityStudentManagement student1 = new UniversityStudentManagement("Alice", "A", "R001");
        student1.displayDetails();
        UniversityStudentManagement student2 = new UniversityStudentManagement("Bob", "B", "R002");
        student2.displayDetails();
        displayTotalStudents();
    }
}