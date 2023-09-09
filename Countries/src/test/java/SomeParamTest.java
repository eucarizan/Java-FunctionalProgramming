import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0}")
    @DisplayName("param test")
    @CsvSource(value = {
            "test1 : Chile|18006000, Colombia|48128000, Brazil|204519000, Peru|33050325, Venezuela|30620000, Mexico|127500000 : " +
                    "[BRAZIL, MEXICO, COLOMBIA]",
            "test2 : '' : []"
    }, delimiter = ':')
    public void test(String name, String input, String expected) {
        List<Country> param;

        if (input.isEmpty()) {
            param = List.of();
        } else {
            param = Arrays.stream(input.split(", "))
                    .map(s -> s.split("\\|"))
                    .map(parts -> new Country(parts[0], Integer.parseInt(parts[1])))
                    .toList();
        }

        String result = Countries.getNamesOfTop3PopulatedCountries(param).toString();

        assertEquals(expected, result);
    }
}
