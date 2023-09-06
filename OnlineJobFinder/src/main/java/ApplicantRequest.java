public class ApplicantRequest {
    private final String company;
    private final int experience;

    public ApplicantRequest(String company, int experience) {
        this.company = company;
        this.experience = experience;
    }

    public String getCompany() {
        return company;
    }

    public int getExperienceYears() {
        return experience;
    }
}
