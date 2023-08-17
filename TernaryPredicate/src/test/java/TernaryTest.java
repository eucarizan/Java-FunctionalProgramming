import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TernaryTest {

    @ParameterizedTest(name = "{index}: allValuesAreDifferent({0}, {1}, {2}) == {3}")
    @CsvSource({"1, 1, 1, False", "2, 3, 4, True", "3, 3, 4, False"})
    public void test(int num1, int num2, int num3, boolean expected) {
        boolean areValuesDifferent = Ternary.allValuesAreDifferent.test(num1, num2, num3);

        assertEquals(expected, areValuesDifferent);
    }

}