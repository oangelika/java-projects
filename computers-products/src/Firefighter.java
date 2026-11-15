public class Firefighter extends Person {
    private String workExperience;

    public Firefighter(String name, String workExperience) {
        super(name);
        this.workExperience = workExperience;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public String display() {
        return super.display() + ", Work Experience: " + workExperience;
    }
}
