import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class SomeParamTest {
    @ParameterizedTest(name = "{0}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testAverageSalaryWithEmptyList : '' : 0.0",
            "testAverageSalaryWithSingleEmployee : Alice|50000 : 50000.0",
            "testAverageSalaryWithMultipleEmployees : John|5000, Alise|6000, Sonya|3000, Chester|4000 : 4500.0",
            "testAverageSalaryWithZeroSalaries : Eve|0, Frank|0, Grace|0 : 0.0",
            "testAverageSalaryWithNegativeSalaries : Hank|-5000, Ivy|-6000, Jack|-7500 : -6166.66",
    }, delimiter = ':')
    public void test(String name, String input, double expected) {
        List<Employee> param;

        if (input.isEmpty()) {
            param = List.of();
        } else {
            param = Arrays.stream(input.split(", "))
                    .map(s -> s.split("\\|"))
                    .map(parts -> new Employee(parts[0], Long.parseLong(parts[1])))
                    .toList();
        }

        double result = AverageSalary.averageSalary(param);

        assertEquals(expected, result, 0.01);
    }

    @Test
    public void testAverageSalaryWithNullEmployees() {
        List<Employee> employeesWithNull = new ArrayList<>();
        employeesWithNull.add(new Employee("John", 50000));
        employeesWithNull.add(null);
        employeesWithNull.add(new Employee("Alice", 60000));
        double result = AverageSalary.averageSalary(employeesWithNull);
        assertEquals(55000.0, result, 0.001);
    }

    @Test
    public void testAverageSalaryWithMixOfPositiveAndNegativeSalaries() {
        // Create a list of employees with mix of positive and negative salaries
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Employee1", 5000));
        employees.add(new Employee("Employee2", -3000));
        employees.add(new Employee("Employee3", 8000));
        employees.add(new Employee("Employee4", -2000));
        employees.add(new Employee("Employee5", 6000));

        // Calculate the expected average
        double expectedAverage = (5000 - 3000 + 8000 - 2000 + 6000) / 5.0;

        // Calculate the average using the method
        double result = AverageSalary.averageSalary(employees);

        // Compare the results with a small tolerance due to double precision
        double tolerance = 1e-9;
        assertEquals(expectedAverage, result, tolerance);
    }

    @Test
    public void testAverageSalaryWithLargeNumberOfEmployees() {
        // Generate a list of 1 million employees with random salaries
        List<Employee> employees = generateLargeListOfEmployees();

        // Calculate the expected average
        double expectedAverage = calculateExpectedAverage(employees);

        // Calculate the average using the method
        double result = AverageSalary.averageSalary(employees);

        // Compare the results with a small tolerance due to double precision
        double tolerance = 1e-9;
        assertEquals(expectedAverage, result, tolerance);
    }

    private List<Employee> generateLargeListOfEmployees() {
        List<Employee> employees = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 1000000; i++) {
            int salary = 20_000 + random.nextInt() * 80_000; // Random salary between 20,000 and 100,000
            employees.add(new Employee("Employee" + i, salary));
        }

        return employees;
    }

    private double calculateExpectedAverage(List<Employee> employees) {
        double totalSalary = 0.0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary / employees.size();
    }
}
