import java.util.Comparator;

public record LongRange(long left, long right) {
    public static Comparator<LongRange> getComparator() {
        // Function<LongRange, Long> byLength = o1 -> o1.right - o1.left;

        // return Comparator.comparing(byLength).thenComparing(LongRange::getLeft);

        return Comparator
                .comparing((LongRange range) -> Math.abs(range.right - range.left))
                .thenComparing(LongRange::left);
    }

    @Override
    public String toString() {
        return String.format("%d %d", left, right);
    }
}
