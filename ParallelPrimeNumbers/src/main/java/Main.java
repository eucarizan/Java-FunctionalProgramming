public class Main {
    public static void main(String[] args) {
        long startRange = 0L;
        long endRange = 100_000L;

        System.out.println("===Count===");
        System.out.println(NumberUtils.createPrimesFilteringStream(startRange, endRange).count());

        System.out.println("===Time Calculation===");
        long start = System.nanoTime();
        NumberUtils.createPrimesFilteringStream(startRange, endRange);
        long elapsedTime = System.nanoTime() - start;
        System.out.println(elapsedTime + " nanoseconds");

        System.out.println("\n===Count with parallel()===");
        System.out.println(NumberUtils.createPrimesFilteringStream(startRange, endRange).count());

        System.out.println("===Time Calculation with parallel()===");
        long startParallel = System.nanoTime();
        NumberUtils.createPrimesFilteringStream(startRange, endRange);
        long elapsedTimeParallel = System.nanoTime() - startParallel;

        System.out.println(elapsedTimeParallel + " nanoseconds");
    }
}