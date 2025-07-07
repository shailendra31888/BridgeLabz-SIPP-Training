import java.util.Scanner;

class StudentReportSimulation{
    String name;
    int rollNumber;
    int marks;

    StudentReportSimulation(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    String calculateGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 50) return "C";
        else return "D";
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        System.out.print("Enter marks: ");
        int marks = scanner.nextInt();
        StudentReportSimulation student = new StudentReportSimulation(name, rollNumber, marks);
        student.displayDetails();
    }
}