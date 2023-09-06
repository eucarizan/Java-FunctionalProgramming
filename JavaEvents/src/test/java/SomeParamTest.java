import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} searchEvents(input) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "searchJavaTest : JavaZone, KotlinConf, java night party | Amsterdam, Day of Java, PyCon US : " +
                    "[Day of Java, JavaZone, java night party | Amsterdam]",
    }, delimiter = ':')
    public void test(String name, String input, String expected) {
        List<String> param = Arrays.stream(input.split(", ")).toList();

        String result = SearchJavaEvents.printSortedJavaEvents(param).toString();

        assertEquals(expected, result);
    }

    @Test
    public void testPrintSortedJavaEventsWithNoJavaEvents() {
        List<String> events = Arrays.asList("KotlinConf", "Python Meetup", "AWS Summit");
        List<String> expected = List.of();
        assertEquals(expected, SearchJavaEvents.printSortedJavaEvents(events));
    }

    @Test
    public void testPrintSortedJavaEventsWithSpecialCharacters() {
        List<String> events = Arrays.asList("JavaOne 2021", "Java Programming Workshop", "AWS Summit", "Java Meetup");
        List<String> expected = Arrays.asList("Java Meetup", "Java Programming Workshop", "JavaOne 2021");
        assertEquals(expected, SearchJavaEvents.printSortedJavaEvents(events));
    }

    @Test
    public void testPrintSortedJavaEventsInRandomOrder() {
        List<String> events = Arrays.asList("Python Meetup", "Day of Java", "KotlinConf", "JavaZone", "PyCon US");
        List<String> expected = Arrays.asList("Day of Java", "JavaZone");
        assertEquals(expected, SearchJavaEvents.printSortedJavaEvents(events));
    }
}
