import java.util.List;
import java.util.stream.Stream;

public class PrintNumbers {
    public static List<Integer> printNumbers(Stream<Integer> numbers, int n, int k) {
        return numbers.skip(k - 1).limit(n).toList();
    }
}
