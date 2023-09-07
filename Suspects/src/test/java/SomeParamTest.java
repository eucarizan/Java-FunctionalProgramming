import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "given [{1}], when {0}, then {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testReduceWords_ContainsJo : maddox hopper, remi joyner, martyn wilks, jim burks, joshua parry, mojo milner : " +
                    "[joshua parry, mojo milner, remi joyner]",
            "testReduceWords_NoJo : apple, banana, cherry : []",
            "testReduceWords_EmptyList : '' : []",
            "testReduceWords_NullList : : []",
            "testReduceWords_CaseInsensitiveMatching : Mary Johnson, jOe SmiTH, Bill Jones : [Bill Jones, Mary Johnson, jOe SmiTH]",
    }, delimiter = ':')
    public void test(String name, String input, String expected) {
        List<String> param;

        if (input == null) {
            param = null;
        } else {
            param = Arrays.stream(input.split(", ")).toList();
        }

        List<String> result = Suspects.reduceSuspects(param);

        assertEquals(expected, result.toString());
    }
}
