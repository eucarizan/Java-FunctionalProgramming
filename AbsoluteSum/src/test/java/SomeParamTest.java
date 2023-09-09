import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} sumOfAbsoluteNumbers({1}) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "1 : 7, 3, -5, 2 : 17",
            "2 : -1, -2, -3 : 6",
            "3 : -10 : 10",
    }, delimiter = ':')
    public void test(String name, String input, long expected) {
        List<Long> param = Arrays.stream(input.split(", "))
                .map(Long::parseLong)
                .toList();

        long result = AbsoluteSum.sumOfAbsoluteNumbers(param);

        assertEquals(expected, result);
    }
}
