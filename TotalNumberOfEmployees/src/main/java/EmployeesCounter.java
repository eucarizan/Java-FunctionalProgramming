import java.util.List;

public class EmployeesCounter {
    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
        return departments.stream()
                .filter(d -> d.code().contains("111-"))
                .flatMap(d -> d.employees().stream())
                .map(Employee::salary)
                .filter(salary -> salary >= threshold)
                .count();
    }
}
