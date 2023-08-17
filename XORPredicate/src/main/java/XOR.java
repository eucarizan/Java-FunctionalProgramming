import java.util.function.Predicate;

public class XOR {
    public static <T> Predicate<T> xor(Predicate<T> p1, Predicate<T> p2) {
        return p1.or(p2).and(p1.and(p2).negate());
    }
}
