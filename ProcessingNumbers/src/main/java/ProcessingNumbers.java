import java.util.Collection;
import java.util.stream.Stream;

public class ProcessingNumbers {
    public static Stream<Integer> getStream(Collection<Integer> numbers) {
        if (numbers.isEmpty()) {
            return Stream.of();
        }

        return numbers.stream()
                .distinct()
                .sorted()
                .takeWhile(n -> n < 100);
    }
}
