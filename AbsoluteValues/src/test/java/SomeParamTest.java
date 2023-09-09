import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0}")
    @DisplayName("param test")
    @CsvSource(value = {
            "test1 : 0, -1, 2, -3, 4, -5 : 0 1 2 3 4 5",
            "test2 : '' : ''"
    }, delimiter = ':')
    public void test(String name, String input, String expected) {
        List<String> param;
        if (input.isEmpty()) {
            param = List.of();
        } else {
            param = Arrays.stream(input.split(", ")).toList();
        }

        String result = AbsoluteNumbers.abs(param);

        assertEquals(expected, result);
    }
}
