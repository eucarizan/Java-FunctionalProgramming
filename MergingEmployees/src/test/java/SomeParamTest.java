import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest
    @DisplayName("param test")
    @CsvSource(value = {
            "test : Jess, Clarisa, Noe, Jeri : Helena, Kristin, Juan : Jess, Clarisa, Noe, Jeri, Helena, Kristin, Juan"
    }, delimiter = ':')
    public void test(String name, String stream1, String stream2, String expectedStr) {
        Stream<String> param1 = Arrays.stream(stream1.split(", "));
        Stream<String> param2 = Arrays.stream(stream2.split(", "));
        Stream<String> expected = Arrays.stream(expectedStr.split(", "));

        Stream<String> result = MergingEmployees.mergeEmployees(param1, param2);

        assertEquals(expected.toList(), result.toList());
    }
}
