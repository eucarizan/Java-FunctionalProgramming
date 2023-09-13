import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} -- calcAverageSalary({1}) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testSumWithPositiveNumbers : 4500, 5200, 3900 : 4533.33",
            "testSumWithEmptyArray : '' : 0.0",
            "testSumWithNegativeNumbers : -1000, -2000, -3000, -4000, -5000 : -3000.0",
            "testSumWithNegativeNumbers : -1, 2, -3, 4, -5 : -0.6",
            "testSumWithSingleNumber : 42 : 42",
            "testSumWithLargeNumbers : 1000000000, 2000000000, 3000000000 : 2000000000",
    }, delimiter = ':')
    public void test(String name, String input, double expected) {
        List<Long> param;

        if (input.isEmpty()) {
            param = List.of();
        } else {
            param = Arrays.stream(input.split(", "))
                    .map(Long::parseLong)
                    .toList();
        }

        double result = CalculateAverageSalary.calcAverageSalary(param);

        assertEquals(expected, result, 0.01);
    }
}
