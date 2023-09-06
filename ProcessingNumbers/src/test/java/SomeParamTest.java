import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} processNumbers(input}) == [{2}]")
    @DisplayName("param test")
    @CsvSource(value = {
            "test : 40, 100, 50, 30, 60, 110, 40, 70, 120 : 30 40 50 60 70",
    }, delimiter = ':')
    public void test(String name, String input, String expected) {
        List<Integer> param = Arrays.stream(input.split(", ")).map(Integer::parseInt).toList();

//        String result = ProcessingNumbers.getStream(param).toList().toString();
        String result = ProcessingNumbers.getStream(param)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        assertEquals(expected, result);
    }

    @Test
    public void testEmptyCollection() {
        Collection<Integer> numbers = Collections.emptyList();
        Stream<Integer> result = ProcessingNumbers.getStream(numbers);
        assertEquals(0, result.count());
    }

    @Test
    public void testDistinctAndSorted() {
        Collection<Integer> numbers = List.of(40, 100, 50, 30, 60, 40, 70);
        Stream<Integer> result = ProcessingNumbers.getStream(numbers);
        List<Integer> resultList = result.collect(Collectors.toList());
        assertEquals(List.of(30, 40, 50, 60, 70), resultList);
    }

    @Test
    public void testAllNumbersEqual() {
        Collection<Integer> numbers = List.of(42, 42, 42, 42, 42);
        Stream<Integer> result = ProcessingNumbers.getStream(numbers);
        assertEquals(1, result.count());
    }

    @Test
    public void testNumbersGreaterThan100() {
        Collection<Integer> numbers = List.of(150, 200, 250, 300);
        Stream<Integer> result = ProcessingNumbers.getStream(numbers);
        assertEquals(0, result.count());
    }

    @Test
    public void testNumbersWithNegativeValues() {
        Collection<Integer> numbers = List.of(-50, 30, -70, 80);
        Stream<Integer> result = ProcessingNumbers.getStream(numbers);
        List<Integer> resultList = result.collect(Collectors.toList());
        assertEquals(List.of(-70, -50, 30, 80), resultList);
    }

    @Test
    public void testLargeCollection() {
        // Generate a large collection of numbers from 1 to 1000
        List<Integer> largeCollection = Stream.iterate(1, i -> i + 1)
                .limit(1000)
                .collect(Collectors.toList());

        // Get the stream and verify it doesn't throw an exception
        Stream<Integer> resultStream = ProcessingNumbers.getStream(largeCollection);
        assertNotNull(resultStream);

        // Collect the stream into a list for assertions
        List<Integer> result = resultStream.toList();

        // Check if the stream only contains numbers less than 100
        assertTrue(result.stream().allMatch(n -> n < 100));
    }

    @Test
    public void testNumbersNear100() {
        // Create a collection with numbers near 100
        List<Integer> numbersNear100 = List.of(99, 100, 101);

        // Get the stream
        Stream<Integer> resultStream = ProcessingNumbers.getStream(numbersNear100);

        // Collect the stream into a list for assertions
        List<Integer> result = resultStream.toList();

        // Check if the stream contains only numbers less than 100
        assertTrue(result.stream().allMatch(n -> n < 100));
    }
}
