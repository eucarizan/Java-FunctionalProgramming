import java.util.stream.Stream;

public class Ternary {
    public static final TernaryIntPredicate<Integer, Integer, Integer> allValuesAreDifferent = (x, y, z) -> {
        return !x.equals(y) && !y.equals(z) && !z.equals(x);
    };

    public static final TernaryIntPredicate<Integer, Integer, Integer> allValuesAreDifferentStream = (a, b, c) ->
            Stream.of(a, b, c).distinct().count() == 3;
}
