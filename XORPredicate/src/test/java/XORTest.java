import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class XORTest {

    @ParameterizedTest(name = "{index}: xor({0}, {1}) == {2}")
    @CsvSource({"false, false, false", "false, true, true", "true, true, false", "true, false, true"})
    void givenBooleanThenExpectResult(boolean param1, boolean param2, boolean expected) {
        boolean result = XOR.xor((t) -> param1, (t) -> param2).test(null);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "{0} -> xor(isEven, isLessThan11) == {1}")
    @CsvSource({"10, false", "13, false", "14, true", "9, true"})
    void givenNumbersWhenTestInPredicateThenExpectResult(int num, boolean expected) {
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isLessThan11 = x -> x < 11;
        boolean result = XOR.xor(isEven, isLessThan11).test(num);

        assertEquals(expected, result);
    }
}