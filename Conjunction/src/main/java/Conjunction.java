import java.util.List;
import java.util.function.IntPredicate;

public class Conjunction {
    public static IntPredicate conjunctAll(List<IntPredicate> predicates) {
        return n -> {
            if (predicates.isEmpty()) return true;

            IntPredicate trueIP = (a) -> true;
            for (IntPredicate intPredicate : predicates) {
                trueIP = trueIP.and(intPredicate);
            }

            return trueIP.test(n);
        };
    }

    public static IntPredicate conjunctAllStream(List<IntPredicate> predicates) {
        return predicates.stream().reduce(a -> true, IntPredicate::and);
    }
}
