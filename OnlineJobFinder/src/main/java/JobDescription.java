public class JobDescription {
    private final String title;
    private final String company;
    private final int requiredExperience;

    public JobDescription(String title, String company, int requiredExperience) {
        this.title = title;
        this.company = company;
        this.requiredExperience = requiredExperience;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public int getRequiredExperienceYears() {
        return requiredExperience;
    }
}
