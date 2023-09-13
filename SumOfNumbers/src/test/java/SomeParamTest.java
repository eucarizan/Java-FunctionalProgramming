import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} -- sum({1}) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testSum_withPositiveNumbers : 3, 1, 2 : 6",
            "testSum_withEmptyArray : '' : 0",
            "testSum_withNegativeNumbers : -1, -2, -3, -4, -5 : -15",
            "testSum_withSingleElementArray : 10 : 10",
    }, delimiter = ':')
    public void test(String name, String input, long expected) {
        long[] param;

        if (input.isEmpty()) {
            param = new long[]{};
        } else {
            param = Arrays.stream(input.split(", "))
                    .mapToLong(Long::parseLong)
                    .toArray();
        }

        long result = SumOfNumbers.sum(param);

        assertEquals(expected, result);
    }

    @Test
    public void testSum_withLargeArray() {
        // Prepare input data
        long[] numbers = new long[10000];
        for (int i = 0; i < 10000; i++) {
            numbers[i] = i + 1;
        }
        long expected = 50005000;

        // Execute the sum function
        long result = SumOfNumbers.sum(numbers);

        // Assert that the expected value matches the result
        assertEquals(expected, result);
    }
}
