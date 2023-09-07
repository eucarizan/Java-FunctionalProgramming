import java.util.List;

public class Suspects {
    public static List<String> reduceSuspects(List<String> suspects) {
        if (suspects == null) {
            return List.of();
        }

        return suspects.stream()
                .filter(suspect -> suspect.toLowerCase().contains("jo"))
                .sorted()
                .toList();
    }
}
