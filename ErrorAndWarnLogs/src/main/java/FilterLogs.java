import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FilterLogs {
    public static Map<Instant, Log> notInfoLogs(List<Log> logs) {
        return logs.stream()
                .filter(log -> !Objects.equals(log.getType(), "INFO"))
                .collect(Collectors.toMap(Log::getTimestamp, Function.identity()));
    }

    public static Map<Instant, Log> notInfoLogs(List<Log> logs, String typeToFilter) {
        return logs.stream()
                .filter(log -> !Objects.equals(log.getType(), typeToFilter))
                .collect(Collectors.toMap(Log::getTimestamp, Function.identity(), (first, second) -> first));
    }
}
