import java.time.Instant;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Log> logs = List.of(
                new Log(Instant.now(), "ERROR", 100L),
                new Log(Instant.now(), "WARN", 200L),
                new Log(Instant.now(), "INFO", 300L)
        );

        System.out.println(FilterLogs.notInfoLogs(logs));
    }
}