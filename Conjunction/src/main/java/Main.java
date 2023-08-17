import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class Main {

    public static IntPredicate conjunctAll(List<IntPredicate> predicates) {
        return n -> {
            if (predicates.isEmpty()) return true;

            IntPredicate trueIP = (a) -> true;
            for (IntPredicate intPredicate : predicates) {
                trueIP = trueIP.and(intPredicate);
            }

            return trueIP.test(n);
        };
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] strings = scanner.nextLine().split("\\s+");

            List<Boolean> values;
            if (strings[0].trim().isEmpty()) {
                values = List.of();
            } else {
                values = Arrays.stream(strings)
                        .map(Boolean::parseBoolean)
                        .collect(Collectors.toList());
            }

            List<IntPredicate> predicates = new ArrayList<>();
            values.forEach(v -> predicates.add(x -> v));

            System.out.println(conjunctAll(predicates).test(0));
        }
    }
}
