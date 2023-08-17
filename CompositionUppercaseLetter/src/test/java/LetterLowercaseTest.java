import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LetterLowercaseTest {

    @ParameterizedTest(name = "{0} -> isLetter && isLower == {1}")
    @CsvSource({"1, false", "3, false", "c, true", "D, false", "e, true", "Q, false"})
    public void testPredicate(char s1, boolean expected) {
        boolean result = LetterLowercase.predicate.test(s1);

        Assertions.assertEquals(expected, result);
    }

}