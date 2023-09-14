import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActivityMonitoring {
    public static Map<String, Long> getUrlToNumberOfVisited(List<LogEntry> logs) {
        return logs.stream()
                .collect(Collectors.groupingBy(LogEntry::url, Collectors.counting()));
    }
}