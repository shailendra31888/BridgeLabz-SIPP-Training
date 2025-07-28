
import java.util.*;

// Abstract base for course types
abstract class CourseType {

    private String title;
    private int credits;

    public CourseType(String title, int credits) {
        this.title = title;
        this.credits = credits;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    public abstract String getEvaluationMethod();

    @Override
    public String toString() {
        return title + " (" + credits + " credits, " + getEvaluationMethod() + ")";
    }
}

// Concrete course types
class ExamCourse extends CourseType {

    public ExamCourse(String title, int credits) {
        super(title, credits);
    }

    @Override
    public String getEvaluationMethod() {
        return "Exam-Based";
    }
}

class AssignmentCourse extends CourseType {

    public AssignmentCourse(String title, int credits) {
        super(title, credits);
    }

    @Override
    public String getEvaluationMethod() {
        return "Assignment-Based";
    }
}

class ResearchCourse extends CourseType {

    public ResearchCourse(String title, int credits) {
        super(title, credits);
    }

    @Override
    public String getEvaluationMethod() {
        return "Research-Based";
    }
}

// Generic Course class
class Course<T extends CourseType> {

    private T courseType;
    private String department;
    private String instructor;

    public Course(T courseType, String department, String instructor) {
        this.courseType = courseType;
        this.department = department;
        this.instructor = instructor;
    }

    public T getCourseType() {
        return courseType;
    }

    public String getDepartment() {
        return department;
    }

    public String getInstructor() {
        return instructor;
    }

    @Override
    public String toString() {
        return courseType + " | Dept: " + department + " | Instructor: " + instructor;
    }
}

// Utility to display any list of CourseType (wildcard)
class CourseUtils {

    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType c : courses) {
            System.out.println(c);
        }
    }
}

public class UniversityCourseManagementDemo {

    public static void main(String[] args) {
        // Create courses of different types
        Course<ExamCourse> math = new Course<>(new ExamCourse("Calculus", 4), "Mathematics", "Dr. Rao");
        Course<AssignmentCourse> cs = new Course<>(new AssignmentCourse("Data Structures", 3), "CS", "Prof. Mehta");
        Course<ResearchCourse> bio = new Course<>(new ResearchCourse("Genetics Research", 5), "Biology", "Dr. Singh");

        // Catalog can hold any course type
        List<CourseType> catalog = new ArrayList<>();
        catalog.add(math.getCourseType());
        catalog.add(cs.getCourseType());
        catalog.add(bio.getCourseType());

        System.out.println("University Course Catalog:");
        CourseUtils.displayAllCourses(catalog);

        // You can also use wildcards to display any type of course
        List<ExamCourse> examCourses = Arrays.asList(new ExamCourse("Physics", 4), new ExamCourse("Chemistry", 4));
        System.out.println("\nExam-Based Courses:");
        CourseUtils.displayAllCourses(examCourses);

        List<AssignmentCourse> assignmentCourses = Arrays.asList(new AssignmentCourse("Database Systems", 3), new AssignmentCourse("AI Ethics", 3));
        System.out.println("\nAssignment-Based Courses:");
        CourseUtils.displayAllCourses(assignmentCourses);

        List<ResearchCourse> researchCourses = Arrays.asList(new ResearchCourse("Quantum Computing Research", 5));
        System.out.println("\nResearch-Based Courses:");
        CourseUtils.displayAllCourses(researchCourses);
    }
}
