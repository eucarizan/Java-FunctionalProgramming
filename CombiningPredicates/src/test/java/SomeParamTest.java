import org.junit.jupiter.api.Test;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SomeParamTest {
    @Test
    public void testConjunctAllWithNoPredicates() {
        Stream<IntPredicate> predicates = Stream.of();
        IntPredicate result = CombiningPredicates.conjunctAll(predicates);
        assertTrue(result.test(42)); // Empty predicates should always return true
    }

    @Test
    public void testConjunctAllWithSinglePredicate() {
        Stream<IntPredicate> predicates = Stream.of(x -> x % 2 == 0);
        IntPredicate result = CombiningPredicates.conjunctAll(predicates);
        assertTrue(result.test(4));
        assertFalse(result.test(3));
    }

    @Test
    public void testConjunctAllWithMultiplePredicates() {
        Stream<IntPredicate> predicates = Stream.of(
                x -> x % 2 == 0,
                x -> x >= 0,
                x -> x <= 100
        );
        IntPredicate result = CombiningPredicates.conjunctAll(predicates);
        assertTrue(result.test(42));
        assertFalse(result.test(101));
        assertFalse(result.test(-1));
    }

    @Test
    public void testConjunctAllWithLargeRange() {
        Stream<IntPredicate> predicates = Stream.of(x -> x % 2 == 0);
        IntPredicate result = CombiningPredicates.conjunctAll(predicates);

        // Test a large range of values
        IntStream.range(0, 1_000_000).forEach(x -> {
            if (x % 2 == 0) {
                assertTrue(result.test(x));
            } else {
                assertFalse(result.test(x));
            }
        });
    }
}
