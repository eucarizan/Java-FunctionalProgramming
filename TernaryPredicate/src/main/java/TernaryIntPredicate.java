@FunctionalInterface
public interface TernaryIntPredicate<T, U, V> {
    public boolean test(T t, U u, V v);
}
