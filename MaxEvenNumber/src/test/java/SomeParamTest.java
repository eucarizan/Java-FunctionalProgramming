import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} findMaxEvenNumber({1}) == [{2}]")
    @DisplayName("param test")
    @CsvSource(value = {
            "testHasMaxEven : 40, 81, 27, 86, 79 : 86",
            "testOnlyOddInputs : 41, 81, 27, 87, 79 : 0",
    }, delimiter = ':')
    public void test(String name, String input, int expected) {
        List<Integer> param = Arrays.stream(input.split(", ")).map(Integer::parseInt).toList();

        int result = MaxEvenNumber.findMaxEvenNumber(param);

        assertEquals(expected, result);
    }

    @Test
    public void testFindMaxEvenNumberWithMixedNumbers() {
        List<Integer> numbers = Arrays.asList(2, 6, 1, 9, 4, 8, 3);
        int expected = 8;
        assertEquals(expected, MaxEvenNumber.findMaxEvenNumber(numbers));
    }

    @Test
    public void testFindMaxEvenNumberWithEmptyList() {
        List<Integer> numbers = List.of();
        int expected = 0;
        assertEquals(expected, MaxEvenNumber.findMaxEvenNumber(numbers));
    }

    @Test
    public void testFindMaxEvenNumberWithNegativeEvenNumbers() {
        List<Integer> numbers = Arrays.asList(-6, -2, -8, -4);
        int expected = -2;
        assertEquals(expected, MaxEvenNumber.findMaxEvenNumber(numbers));
    }

    @Test
    public void testFindMaxEvenNumberWithAllNegativeNumbers() {
        List<Integer> numbers = Arrays.asList(-1, -3, -5, -7);
        int expected = 0;
        assertEquals(expected, MaxEvenNumber.findMaxEvenNumber(numbers));
    }
}
