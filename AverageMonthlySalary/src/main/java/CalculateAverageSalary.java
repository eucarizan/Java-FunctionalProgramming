import java.util.Collection;

public class CalculateAverageSalary {
    public static double calcAverageSalary(Collection<Long> salaries) {
        return salaries.stream()
                .mapToDouble(i -> i)
                .average()
                .orElse(0.0);
    }
}
