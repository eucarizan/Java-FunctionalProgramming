import java.util.Arrays;
import java.util.Collection;

public class SumOfNumbers {
    public static long sum(long[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    public static double sum(Collection<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(i -> i)
                .average().orElse(0.0);
    }
}
