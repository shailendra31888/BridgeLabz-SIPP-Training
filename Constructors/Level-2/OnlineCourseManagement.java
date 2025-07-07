public class OnlineCourseManagement {
    private String courseName;
    private int duration;
    private double fee;
    private static String instituteName;

    public OnlineCourseManagement(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: $" + fee);
    }

    public static void updateInstituteName(String name) {
        instituteName = name;
    }

    public static void main(String[] args) {
        OnlineCourseManagement course1 = new OnlineCourseManagement("Java Programming", 12, 300);
        OnlineCourseManagement course2 = new OnlineCourseManagement("Data Structures", 8, 250);
        course1.displayCourseDetails();
        course2.displayCourseDetails();
        OnlineCourseManagement.updateInstituteName("Tech Institute");
    }
}