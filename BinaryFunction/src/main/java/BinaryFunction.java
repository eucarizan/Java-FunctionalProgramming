@FunctionalInterface
public interface BinaryFunction<T, U, R> {
    R apply(T t, U u);
}
