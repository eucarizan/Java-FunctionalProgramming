import java.util.function.IntPredicate;
import java.util.stream.Stream;

public class CombiningPredicates {
    public static IntPredicate conjunctAll(Stream<IntPredicate> predicates) {
        return predicates.reduce(a -> true, IntPredicate::and);
    }
}
