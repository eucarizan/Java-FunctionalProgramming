import java.util.Collection;

public class OnlineJobSystem {
    public static long calculateNumberOfVacancies(ApplicantRequest request, Collection<JobDescription> jobs) {
        return jobs.stream()
                .filter(job -> job.getCompany().equals(request.getCompany()))
                .filter(job -> job.getRequiredExperienceYears() <= request.getExperienceYears())
                .filter(job -> job.getRequiredExperienceYears() > 0)
                .count();
    }
}
