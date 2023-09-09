import java.util.List;
import java.util.stream.Collectors;

public class AbsoluteNumbers {
    public static String abs(List<String> numbers) {
        return numbers.stream()
                .map(Integer::parseInt)
                .map(Math::abs)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
