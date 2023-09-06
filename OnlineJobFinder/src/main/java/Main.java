import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] requestParts = scanner.nextLine().split("\\|");
        ApplicantRequest request = new ApplicantRequest(requestParts[0], Integer.parseInt(requestParts[1]));

        List<JobDescription> jobs = Stream.iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
                .map(i -> scanner.nextLine())
                .map(inputLine -> {
                    String[] parts = inputLine.split("\\|");
                    return new JobDescription(parts[0], parts[1], Integer.parseInt(parts[2]));
                })
                .collect(Collectors.toList());

        System.out.println(OnlineJobSystem.calculateNumberOfVacancies(request, jobs));
    }
}