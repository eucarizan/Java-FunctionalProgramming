import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} -- countAllByTagName({2}) == {3}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testMultipleMatchingTag : " +
                    "1|UTF-8|function;load, 2|UTF-8|table;main, 3|ASCII|row;column, 4|ASCII|sheet;row, 5|ASCII|sheet;column;row : " +
                    "sheet : " +
                    "{UTF-8=0, ASCII=5}",
            "testOneMatchingTag : " +
                    "1|UTF-8|function : " +
                    "function : " +
                    "{UTF-8=1}",
            "testNoMatchingTag : " +
                    "1|UTF-8|function;load, 2|UTF-8|table;main, 3|ASCII|row;column, 4|ASCII|sheet;row, 5|ASCII|sheet;column;row : " +
                    "div : " +
                    "{UTF-8=0, ASCII=0}",
    }, delimiter = ':')
    public void test(String name, String input, String tagName, String expected) {
        List<XmlFile> param = Arrays.stream(input.split(", "))
                .map(s -> s.split("\\|"))
                .map(parts -> new XmlFile(
                        parts[0],
                        parts[1],
                        Arrays.stream(parts[2].split(";"))
                                .map(Tag::new)
                                .toList()))
                .toList();

        String result = XmlUtils.countAllByTagName(param, tagName).toString();

        assertEquals(expected, result);
    }
}
