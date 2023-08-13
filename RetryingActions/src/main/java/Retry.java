@FunctionalInterface
public interface Retry {
    void run(Runnable action, int maxAttempts, long delayBeforeRetryMs);
}
