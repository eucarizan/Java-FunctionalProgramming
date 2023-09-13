import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} -- generateUsers({1}) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testGenerateUsersWithPositiveNumberOfUsers : 5 : [1|user1@gmail.com, 2|user2@gmail.com, 3|user3@gmail.com, 4|user4@gmail.com, 5|user5@gmail.com]",
            "testGenerateUsersWithZeroNumberOfUsers : 0 : []",
            "testGenerateUsersWithNegativeNumberOfUsers : -5 : []",
    }, delimiter = ':')
    public void test(String name, int param, String expected) {

        String result = Utils.generateUsers(param)
                .map(User::toString)
                .collect(Collectors.joining(", ", "[", "]"));

        assertEquals(expected, result);
    }
}
