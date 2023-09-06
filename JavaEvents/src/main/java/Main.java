import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<String> events = Stream
                    .iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
                    .map(i -> scanner.nextLine())
                    .collect(Collectors.toList());

            SearchJavaEvents.printSortedJavaEvents(events);
        }
    }
}