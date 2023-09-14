import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} -- groupByStringLength({1}) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testGroupWithEmptyList : '' : {}",
            "testGroupWithSingleWord : apple : {5=[apple]}",
            "testGroupWithMultipleWords : Java, main, stream, util, int : {3=[int], 4=[Java, main, util], 6=[stream]}",
            "testGroupWithWordsContainingSpecialCharacters : apple, ba&na-na, cherry!, date, fig : " +
                    "{3=[fig], 4=[date], 5=[apple], 7=[cherry!], 8=[ba&na-na]}",
            "testGroupWithWordsOfMinAndMaxLength : a, apple, abracadabra, supercalifragilisticexpialidocious : " +
                    "{1=[a], 34=[supercalifragilisticexpialidocious], 5=[apple], 11=[abracadabra]}",
    }, delimiter = ':')
    public void test(String name, String input, String expected) {
        List<String> param;

        if (input.isEmpty()) {
            param = List.of();
        } else {
            param = Arrays.stream(input.split(", ")).toList();
        }

        String result = Classifier.group(param).toString();

        assertEquals(expected, result);
    }
}
