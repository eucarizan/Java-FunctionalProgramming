import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Grocery> groceries = List.of(
                new Grocery(10, Category.VEGETABLES),
                new Grocery(8, Category.FRUITS),
                new Grocery(5, Category.DAIRY)
        );

        System.out.println(InflationProblem.calculateTotalPriceInFutureUtilizeEnum(4, groceries));
    }
}