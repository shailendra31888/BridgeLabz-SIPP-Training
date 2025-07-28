
import java.util.*;

// Abstract base class for job roles
abstract class JobRole {

    private String candidateName;
    private int yearsOfExperience;

    public JobRole(String candidateName, int yearsOfExperience) {
        this.candidateName = candidateName;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public abstract String getRoleDetails();
}

// Concrete job roles
class SoftwareEngineer extends JobRole {

    private String primaryLanguage;

    public SoftwareEngineer(String candidateName, int yearsOfExperience, String primaryLanguage) {
        super(candidateName, yearsOfExperience);
        this.primaryLanguage = primaryLanguage;
    }

    @Override
    public String getRoleDetails() {
        return "Software Engineer | " + getCandidateName() + " | " + getYearsOfExperience()
                + " yrs | Language: " + primaryLanguage;
    }
}

class DataScientist extends JobRole {

    private String mainTool;

    public DataScientist(String candidateName, int yearsOfExperience, String mainTool) {
        super(candidateName, yearsOfExperience);
        this.mainTool = mainTool;
    }

    @Override
    public String getRoleDetails() {
        return "Data Scientist | " + getCandidateName() + " | " + getYearsOfExperience()
                + " yrs | Tool: " + mainTool;
    }
}

class ProductManager extends JobRole {

    private String domain;

    public ProductManager(String candidateName, int yearsOfExperience, String domain) {
        super(candidateName, yearsOfExperience);
        this.domain = domain;
    }

    @Override
    public String getRoleDetails() {
        return "Product Manager | " + getCandidateName() + " | " + getYearsOfExperience()
                + " yrs | Domain: " + domain;
    }
}

// Generic Resume class
class Resume<T extends JobRole> {

    private T jobRole;
    private String resumeText;

    public Resume(T jobRole, String resumeText) {
        this.jobRole = jobRole;
        this.resumeText = resumeText;
    }

    public T getJobRole() {
        return jobRole;
    }

    public String getResumeText() {
        return resumeText;
    }

    public void process() {
        System.out.println("Processing resume for: " + jobRole.getRoleDetails());
        // Simulate AI screening logic here
        if (resumeText.toLowerCase().contains("ai")) {
            System.out.println("AI skills detected in resume.");
        } else {
            System.out.println("No explicit AI skills found.");
        }
    }
}

// Utility class for screening pipeline
class ScreeningPipeline {

    public static void processAll(List<? extends JobRole> jobRoles) {
        for (JobRole jr : jobRoles) {
            System.out.println(jr.getRoleDetails());
        }
    }
}

public class AIResumeScreeningSystem {

    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume = new Resume<>(
                new SoftwareEngineer("Alice", 5, "Java"), "Experienced in Java, Spring, and AI projects."
        );
        Resume<DataScientist> dsResume = new Resume<>(
                new DataScientist("Bob", 3, "TensorFlow"), "Worked on data pipelines and AI models."
        );
        Resume<ProductManager> pmResume = new Resume<>(
                new ProductManager("Carol", 7, "FinTech"), "Led product teams in FinTech domain."
        );

        // Process individual resumes
        seResume.process();
        dsResume.process();
        pmResume.process();

        // Screening pipeline for multiple job roles
        List<JobRole> candidates = Arrays.asList(
                seResume.getJobRole(),
                dsResume.getJobRole(),
                pmResume.getJobRole()
        );

        System.out.println("\nScreening pipeline for all candidates:");
        ScreeningPipeline.processAll(candidates);
    }
}
