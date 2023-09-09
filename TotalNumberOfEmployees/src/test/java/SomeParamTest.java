import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} method({1}) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "test : dep-1, 111-1 _ William|15000, Sophia|22000, John|20000; dep-2, 222-1 _ Victor|25000 : 20000 : 2",
    }, delimiter = ':')
    public void test(String name, String input, long threshold, long expected) {
        String[] parts = input.split(";");
        List<Department> param = new ArrayList<>();

        for (String part : parts) {
            String[] departmentParts = part.split(" _ ");
            String[] departmentDetails = departmentParts[0].split(", ");
            String deptName = departmentDetails[0];
            String code = departmentDetails[1];

            String[] employees = departmentParts[1].split(", ");
            List<Employee> employeeList = new ArrayList<>();
            for (String employee : employees) {
                String[] empDetail = employee.split("\\|");
                employeeList.add(new Employee(empDetail[0], Long.parseLong(empDetail[1])));
            }

            param.add(new Department(deptName, code, employeeList));
        }

        long result = EmployeesCounter.calcNumberOfEmployees(param, threshold);

        assertEquals(expected, result);
    }
}
