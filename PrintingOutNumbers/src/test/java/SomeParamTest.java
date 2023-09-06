import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} printNumbers({1}, {2}, {3}) == {4}")
    @DisplayName("param test")
    @CsvSource(value = {
            "test1 : 1, 2, 3, 4, 5, 6, 7, 8, 9 : 3 : 5 : [5, 6, 7]",
            "test2 : 1, 2, 3, 4, 5 : 5 : 1 : [1, 2, 3, 4, 5]"
    }, delimiter = ':')
    public void test(String name, String input, int n, int k, String expected) {
        Stream<Integer> param = Arrays.stream(input.split(", ")).map(Integer::parseInt);

        List<Integer> result = PrintNumbers.printNumbers(param, n, k);

        assertEquals(expected, result.toString());
    }
}
