import java.util.List;

public class FirstWordWithoutPrefix {
    public static String findFirstWordWithoutPrefix(List<String> words, String prefix) {
        if (prefix == null) {
            return "";
        }

        return words.stream()
                .filter(word -> !word.startsWith(prefix))
                .findFirst()
                .orElse("");
    }
}
