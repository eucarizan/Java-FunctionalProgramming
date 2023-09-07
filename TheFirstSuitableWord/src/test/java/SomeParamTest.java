import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testFindFirstWordWithoutPrefix : bitcoin, bitrix, bytecode, bingo : bit : bytecode",
            "testFindFirstWordWithoutPrefix_PrefixIsWord : apple, banana, cherry : apple : banana",
            "testFindFirstWordWithoutPrefix_NullPrefix : apple, banana, cherry : : ''",
            "testFindFirstWordWithoutPrefix_NoMatch : apple, banana, cherry : grape : apple",
            "testFindFirstWordWithoutPrefix_EmptyList : '' : test : ''",
            "testFindFirstWordWithoutPrefix_EmptyPrefix : apple, banana, cherry : grape : apple",
    }, delimiter = ':')
    public void test(String name, String input, String prefix, String expected) {
        List<String> param = Arrays.stream(input.split(", ")).toList();

        String result = FirstWordWithoutPrefix.findFirstWordWithoutPrefix(param, prefix);

        assertEquals(expected, result);
    }


}
