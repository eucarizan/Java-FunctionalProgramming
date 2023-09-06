import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} getResults({1}) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "test : 7, 4, 2, 8, 9, 1, 4, 5, 8, 2 : [1, 9, 8, 5]",
    }, delimiter = ':')
    public void test(String name, String input, String expected) {
        Stream<Integer> param = Arrays.stream(input.split(", ")).map(Integer::parseInt);

        String result = Arrays.toString(NumberStreamProcess.getResults(param));

        assertEquals(expected, result);
    }

    @Test
    public void testGetResultsWithDuplicateNumbers() {
        Stream<Integer> stream = Stream.of(5, 5, 5, 5, 5, 5, 5, 5, 5, 5);
        int[] expected = {5, 5, 5, 0};
        assertArrayEquals(expected, NumberStreamProcess.getResults(stream));
    }

    @Test
    public void testGetResultsWithEmptyStream() {
        Stream<Integer> stream = Stream.empty();
        int[] expected = {0, 0, 0, 0};
        assertArrayEquals(expected, NumberStreamProcess.getResults(stream));
    }

    @Test
    public void testGetResultsWithNegativeNumbers() {
        Stream<Integer> stream = Stream.of(-1, -4, -2, -8, -9);
        int[] expected = {-9, -1, -1, 0};
        assertArrayEquals(expected, NumberStreamProcess.getResults(stream));
    }
}
