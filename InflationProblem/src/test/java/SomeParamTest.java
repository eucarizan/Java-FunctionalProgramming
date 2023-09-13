import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} -- {1} year(s), List.of({2}) == {3}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testCalculateTotalPriceInFutureWithVegetables : 5 : 15|VEGETABLES, 10|VEGETABLES : 6075",
            "testCalculateTotalPriceInFutureWithFruits : 3 : 8|FRUITS, 12|FRUITS : 1280",
            "testCalculateTotalPriceInFutureWithDairy : 2 : 5|DAIRY, 10|DAIRY, 15|DAIRY : 120",
            "testCalculateTotalPriceInFutureWithMixedCategories1 : 1 : 15|VEGETABLES, 30|VEGETABLES, 10|FRUITS, 20|DAIRY : 215",
            "testCalculateTotalPriceInFutureWithMixedCategories2 : 3 : 10|FRUITS, 20|DAIRY : 800",
            "testCalculateTotalPriceInFutureWithZeroYears : 0 : 15|VEGETABLES : 15",
            "testCalculateTotalPriceInFutureWithEmptyGroceries : 5 : '' : 0",
            "testCalculateTotalPriceInFutureWithNegativeYears : -2 : 8|DAIRY : 8",
    }, delimiter = ':')
    public void test(String name, int years, String input, long expected) {
        List<Grocery> param;

        if (input.isEmpty()) {
            param = List.of();
        } else {
            param = Arrays.stream(input.split(", "))
                    .map(s -> s.split("\\|"))
                    .map(parts -> new Grocery(Long.parseLong(parts[0]), Category.valueOf(parts[1].toUpperCase())))
                    .toList();
        }

        long result = InflationProblem.calculateTotalPriceInFuture(years, param);

        assertEquals(expected, result);
    }
}
