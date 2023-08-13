import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            long n = scanner.nextInt();

            // modify the lambda expression
            int result = Utils.substitution(n, digit -> digit == 5 ? 1 : digit == 6 ? 2 : digit == 7 ? 3 : digit == 8 ? 4 : digit == 9 ? 5 : digit);

            System.out.println(result);
        }
    }
}
