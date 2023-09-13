import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} -- isIsogram({1}) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testIsIsogramWithIsogramWord : stream : true",
            "testIsIsogramWithNonIsogramWord : java : false",
            "testIsIsogramWithIsogramLongWord : exclusionary : true",
            "testIsIsogramWithEmptyString : '' : true",
            "testIsIsogramWithUpperCaseIsogramWord : Isogram : true",
            "testIsIsogramWithUpperCaseNonIsogramWord : Engineer : false",
            "testIsIsogramWithSpecialCharacters : hello!world : false",
    }, delimiter = ':')
    public void test(String name, String param, boolean expected) {
        boolean result = Isogram.isIsogram(param);

        assertEquals(expected, result);
    }
}
