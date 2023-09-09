import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Countries {
    public static List<String> getNamesOfTop3PopulatedCountries(Collection<Country> countries) {
        return countries.stream()
                .sorted(Comparator.comparing(Country::getPopulation).reversed())
                .limit(3)
                .map(Country::getName)
                .map(String::toUpperCase)
                .toList();
    }
}
