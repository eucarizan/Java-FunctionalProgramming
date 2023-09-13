import java.util.List;
import java.util.function.Function;

public class InflationProblem {
    static final int VEGGIE_MULTIPLIER = 3;
    static final int FRUIT_MULTIPLIER = 4;
    static final int DAIRY_MULTIPLIER = 2;

    public static long calculateTotalPriceInFuture(int numberOfYears, List<Grocery> groceries) {
        Function<String, Integer> getCategoryMultiplier = str -> "vegetables".equalsIgnoreCase(str) ?
                VEGGIE_MULTIPLIER : "fruits".equalsIgnoreCase(str) ? FRUIT_MULTIPLIER : DAIRY_MULTIPLIER;

        return groceries.stream()
                .map(grocery -> new String[]{String.valueOf(grocery.getCost()), String.valueOf(grocery.getCategory())})
                .map(parts -> Long.parseLong(parts[0]) * Math.pow(getCategoryMultiplier.apply(parts[1]), Math.max(0, numberOfYears)))
                .map(Math::round)
                .reduce(0L, Long::sum);
    }

    public static long calculateTotalPriceInFutureUtilizeEnum(int numberOfYears, List<Grocery> groceries) {
        return groceries.stream()
                .map(grocery -> grocery.getCost() * Math.pow(grocery.getCategory().value, numberOfYears))
                .map(Math::round)
                .reduce(0L, Long::sum);

    }
}
