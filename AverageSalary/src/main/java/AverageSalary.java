import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AverageSalary {
    public static double averageSalary(List<Employee> employees) {
        return employees.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.averagingDouble(Employee::getSalary));
    }
}
