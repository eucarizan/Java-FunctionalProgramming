import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Classifier {
    public static Map<Integer, List<String>> group(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(String::length));
    }
}
