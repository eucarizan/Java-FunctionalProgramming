import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("Java", "stream", "main", "util", "int");
        System.out.println(Classifier.group(list));
        List<String> list2 = List.of();
        System.out.println(Classifier.group(list2));
    }
}