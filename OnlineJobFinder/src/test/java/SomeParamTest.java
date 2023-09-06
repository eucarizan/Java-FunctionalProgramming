import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0}")
    @DisplayName("param test")
    @CsvSource(value = {
            "given request company google and 3 years exp, then count of opening is 2 : Google|3; " +
                    "Java Developer|Google|3, " +
                    "Senior Java Developer|Google|7, " +
                    "Super Java Developer|CryptoStartup|3, " +
                    "Junior Java Developer|Google|1 : 2",
    }, delimiter = ':')
    public void test(String name, String input, long expected) {
        String[] parts = input.split(";");
        String[] applicantRequest = parts[0].split("\\|");
        ApplicantRequest request = new ApplicantRequest(applicantRequest[0], Integer.parseInt(applicantRequest[1]));
        List<JobDescription> jobs = Arrays.stream(parts[1].split(", "))
                .map(s -> s.split("\\|"))
                .map(job -> new JobDescription(job[0], job[1], Integer.parseInt(job[2])))
                .toList();

        long result = OnlineJobSystem.calculateNumberOfVacancies(request, jobs);

        assertEquals(expected, result);
    }

    @Test
    public void testCalculateNumberOfVacanciesWithNoMatchingCompany() {
        ApplicantRequest request = new ApplicantRequest("Amazon", 5);
        List<JobDescription> jobs = Arrays.asList(
                new JobDescription("Software Engineer", "Google", 3),
                new JobDescription("Senior Java Developer", "Microsoft", 7),
                new JobDescription("DevOps Engineer", "Amazon", 6),
                new JobDescription("Data Scientist", "Apple", 1)
        );

        long expected = 0;
        assertEquals(expected, OnlineJobSystem.calculateNumberOfVacancies(request, jobs));
    }

    @Test
    public void testCalculateNumberOfVacanciesWithInsufficientExperience() {
        ApplicantRequest request = new ApplicantRequest("Microsoft", 8);
        List<JobDescription> jobs = Arrays.asList(
                new JobDescription("Software Engineer", "Microsoft", 5),
                new JobDescription("Senior Software Engineer", "Microsoft", 10),
                new JobDescription("DevOps Engineer", "Microsoft", 7),
                new JobDescription("Data Scientist", "Microsoft", 2)
        );

        long expected = 3;
        assertEquals(expected, OnlineJobSystem.calculateNumberOfVacancies(request, jobs));
    }

    @Test
    public void testCalculateNumberOfVacanciesWithEmptyJobList() {
        ApplicantRequest request = new ApplicantRequest("Amazon", 5);
        List<JobDescription> jobs = List.of();

        long expected = 0;
        assertEquals(expected, OnlineJobSystem.calculateNumberOfVacancies(request, jobs));
    }

    @Test
    public void testCalculateNumberOfVacanciesWithNegativeExperience() {
        // Edge Case: Negative Experience Years
        ApplicantRequest negativeExperienceRequest = new ApplicantRequest("Google", -2);
        List<JobDescription> jobDescriptions = new ArrayList<>();
        long negativeExperienceVacancies = OnlineJobSystem.calculateNumberOfVacancies(negativeExperienceRequest, jobDescriptions);
        assertEquals(0, negativeExperienceVacancies, "Negative experience years should result in 0 vacancies");
    }

    @Test
    public void testCalculateNumberOfVacanciesWithNullCompany() {
        // Edge Case: Null or Empty Company
        ApplicantRequest nullCompanyRequest = new ApplicantRequest(null, 2);
        List<JobDescription> jobDescriptions = new ArrayList<>();
        long nullCompanyVacancies = OnlineJobSystem.calculateNumberOfVacancies(nullCompanyRequest, jobDescriptions);
        assertEquals(0, nullCompanyVacancies, "Null company should result in 0 vacancies");
    }

    @Test
    public void testCalculateNumberOfVacanciesWithNegativeExperienceJob() {
        // Edge Case: Jobs with Negative Experience Requirements
        ApplicantRequest request = new ApplicantRequest("Google", 3);
        JobDescription negativeExperienceJob = new JobDescription("Negative Experience Job", "Google", -1);
        List<JobDescription> jobDescriptions = new ArrayList<>();
        jobDescriptions.add(negativeExperienceJob);
        long negativeExperienceJobVacancies = OnlineJobSystem.calculateNumberOfVacancies(request, jobDescriptions);
        assertEquals(0, negativeExperienceJobVacancies, "Jobs with negative experience requirements should be ignored");
    }

    @Test
    public void testCalculateNumberOfVacanciesWithLargeJobList() {
        // Edge Case: Large Number of Jobs
        ApplicantRequest request = new ApplicantRequest("Google", 3);
        JobDescription javaDevGoogle = new JobDescription("Java Developer", "Google", 3);
        List<JobDescription> largeJobList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            largeJobList.add(javaDevGoogle); // Adding the same job description many times
        }
        long largeJobListVacancies = OnlineJobSystem.calculateNumberOfVacancies(request, largeJobList);
        assertEquals(1000, largeJobListVacancies, "Large number of jobs should be handled efficiently");
    }

    @Disabled
    @Test
    public void testConcurrency() throws InterruptedException, ExecutionException {
        int numThreads = 10;
        int numJobs = 1000;

        // Create a thread pool for concurrent execution
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // Create a collection of job descriptions with some matching and some non-matching jobs
        List<JobDescription> jobs = new ArrayList<>();
        for (int i = 0; i < numJobs; i++) {
            jobs.add(new JobDescription("Job " + i, "Google", 5));
        }

        // Create applicant requests with various experience levels
        List<Callable<Long>> tasks = getCallables(jobs);

        // Submit tasks for execution
        List<Future<Long>> futures = executor.invokeAll(tasks);

        // Check the results
        List<Long> results = new ArrayList<>();
        for (Future<Long> future : futures) {
            results.add(future.get());
        }

        // Shut down the executor
        executor.shutdown();

        // Ensure that the results match the expected values
        assertEquals(477, results.get(0).intValue());
        assertEquals(523, results.get(1).intValue());
        assertEquals(0, results.get(2).intValue());
    }

    private static List<Callable<Long>> getCallables(List<JobDescription> jobs) {
        List<ApplicantRequest> requests = List.of(
                new ApplicantRequest("Google", 3),
                new ApplicantRequest("Google", 7),
                new ApplicantRequest("Microsoft", 5)
        );

        // Use a Callable to calculate the number of vacancies for each request concurrently
        List<Callable<Long>> tasks = new ArrayList<>();
        for (ApplicantRequest request : requests) {
            tasks.add(() -> OnlineJobSystem.calculateNumberOfVacancies(request, jobs));
        }
        return tasks;
    }

}
