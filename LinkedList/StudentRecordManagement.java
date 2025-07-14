class StudentNode {

    int rollNumber;
    String name;
    int age;
    String grade;
    StudentNode next;

    public StudentNode(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {

    private StudentNode head;

    // Add at beginning
    public void addAtBeginning(int roll, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Add at end
    public void addAtEnd(int roll, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int pos, int roll, String name, int age, String grade) {
        if (pos <= 1) {
            addAtBeginning(roll, name, age, grade);
            return;
        }
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        StudentNode temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            addAtEnd(roll, name, age, grade);
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete by Roll Number
    public void deleteByRollNumber(int roll) {
        if (head == null) {
            return;
        }
        if (head.rollNumber == roll) {
            head = head.next;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null && temp.next.rollNumber != roll) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Search by Roll Number
    public StudentNode searchByRollNumber(int roll) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Update grade by Roll Number
    public boolean updateGrade(int roll, String newGrade) {
        StudentNode student = searchByRollNumber(roll);
        if (student != null) {
            student.grade = newGrade;
            return true;
        }
        return false;
    }

    // Display all records
    public void displayAll() {
        StudentNode temp = head;
        if (temp == null) {
            System.out.println("No student records found.");
            return;
        }
        while (temp != null) {
            System.out.println("Roll: " + temp.rollNumber + ", Name: " + temp.name
                    + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentRecordManagement {

    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();

        // Sample usage
        list.addAtBeginning(1, "Alice", 20, "A");
        list.addAtEnd(2, "Bob", 21, "B");
        list.addAtPosition(2, 3, "Charlie", 22, "C");

        System.out.println("All records:");
        list.displayAll();

        System.out.println("\nUpdating grade for Roll 2:");
        if (list.updateGrade(2, "A+")) {
            System.out.println("Grade updated.");
        } else {
            System.out.println("Student not found.");
        }
        list.displayAll();

        System.out.println("\nDeleting Roll 1:");
        list.deleteByRollNumber(1);
        list.displayAll();

        System.out.println("\nSearching for Roll 3:");
        StudentNode found = list.searchByRollNumber(3);
        if (found != null) {
            System.out.println("Found: " + found.name + ", Grade: " + found.grade);
        } else {
            System.out.println("Student not found.");
        }
    }
    
}
