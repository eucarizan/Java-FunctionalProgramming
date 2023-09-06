import java.util.Collection;

public class MaxEvenNumber {
    public static int findMaxEvenNumber(Collection<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .max(Integer::compareTo)
                .orElse(0);
    }
}
