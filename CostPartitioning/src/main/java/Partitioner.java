import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Partitioner {
    public static Map<Boolean, List<Application>> getPartition(List<Application> applications) {
        return applications.stream()
                .collect(Collectors.partitioningBy(Application::isFree));
    }
}
