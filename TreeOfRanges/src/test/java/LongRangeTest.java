import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class LongRangeTest {


    Set<LongRange> numbers;

    @Before
    public void beforeTest() {
        numbers = new TreeSet<>(LongRange.getComparator());
    }


    @Test
    public void givenRangesWhenAddedInSetThenExpectSorted() {
        List<String> expected = List.of(
                "2 4",
                "3 5",
                "1 4",
                "0 5",
                "1 7"
        );


        numbers.add(new LongRange(0, 5));
        numbers.add(new LongRange(2, 4));
        numbers.add(new LongRange(1, 4));
        numbers.add(new LongRange(1, 7));
        numbers.add(new LongRange(3, 5));

        List<String> result = new ArrayList<>();

        numbers.forEach(r -> result.add(r.toString()));

        assertEquals(expected, result);
    }

    @Test
    public void givenRangesWithNegativeWhenAddedInSetThenExpectSorted() {
        List<String> expected = List.of(
                "-4 1",
                "0 5",
                "-10 0",
                "0 10"
                );


        numbers.add(new LongRange(0, 10));
        numbers.add(new LongRange(-10, 0));
        numbers.add(new LongRange(0, 5));
        numbers.add(new LongRange(-4, 1));

        List<String> result = new ArrayList<>();

        numbers.forEach(r -> result.add(r.toString()));

        assertEquals(expected, result);
    }
}