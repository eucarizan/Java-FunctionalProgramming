import java.util.Collection;

public class AbsoluteSum {
    public static long sumOfAbsoluteNumbers(Collection<Long> numbers) {
        return numbers.stream()
                .reduce(0L, (sum, next) ->
                        sum + Math.abs(next));
    }
}
