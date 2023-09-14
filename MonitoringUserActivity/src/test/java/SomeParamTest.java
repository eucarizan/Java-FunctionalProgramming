import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} -- method({1}) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testWithEmptyList : '' : {}",
            "testWithSingleEntry : user1|/page1 : {/page1=1}",
            "testWithMultipleEntries : user1|/page1, user2|/page2, user1|/page1, user2|/page3 : {/page1=2, /page3=1, /page2=1}",
            "testWithDuplicateEntries : user1|/page1, user2|/page2, user1|/page1 : {/page1=2, /page2=1}",
    }, delimiter = ':')
    public void test(String name, String input, String expected) {
        List<LogEntry> param;

        if (input.isEmpty()) {
            param = List.of();
        } else {
            param = Arrays.stream(input.split(", "))
                    .map(s -> s.split("\\|"))
                    .map(parts -> new LogEntry(new Date(), parts[0], parts[1]))
                    .toList();
        }

        String result = UserActivityMonitoring.getUrlToNumberOfVisited(param).toString();

        assertEquals(expected, result);
    }
}
