import java.util.List;

public class SearchJavaEvents {
    public static List<String> printSortedJavaEvents(List<String> events) {
        return events.stream()
                .filter(event -> event.toLowerCase().contains("java"))
                .sorted()
                .toList();
    }
}