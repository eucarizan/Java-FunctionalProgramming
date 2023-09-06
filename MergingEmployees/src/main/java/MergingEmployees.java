import java.util.stream.Stream;

public class MergingEmployees {
    public static Stream<String> mergeEmployees(Stream<String> empls1, Stream<String> empls2) {
        return Stream.concat(empls1, empls2).sorted();
    }
}
