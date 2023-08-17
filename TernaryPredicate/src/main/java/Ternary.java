public class Ternary {
    public static final TernaryIntPredicate<Integer, Integer, Integer> allValuesAreDifferent = (x, y, z) -> {
        return !x.equals(y) && !y.equals(z) && !z.equals(x);
    };
}
