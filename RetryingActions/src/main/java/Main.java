import java.util.Scanner;

public class Main {
    private static final int MAX_ATTEMPTS = 10;
    private static final long DELAY_MS = 1;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            RetryUtils.retry.run(() -> System.out.println(scanner.nextLine()), MAX_ATTEMPTS, DELAY_MS);
        }
    }
}
