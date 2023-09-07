import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testCheckPulseMeasurements_AllInRange : 90, 93, 100, 107, 110, 105 : true",
            "testCheckPulseMeasurements_OutOfRange : 130, 135, 142, 147, 151, 144 : false",
            "testCheckPulseMeasurements_BoundaryValues : 90, 150 : true",
            "testCheckPulseMeasurements_EmptyList : '' : true",
    }, delimiter = ':')
    public void test(String name, String input, boolean expected) {
        List<Integer> param;
        if (input.isEmpty()) {
            param = List.of();
        } else {
            param = Arrays.stream(input.split(", ")).map(Integer::parseInt).toList();
        }

        boolean result = HealthChecker.checkPulseMeasurements(param);

        assertEquals(expected, result);
    }

    @Test
    public void testCheckPulseMeasurements_NullList() {
        List<Integer> pulseMeasurements = null;
        assertThrows(NullPointerException.class, () -> HealthChecker.checkPulseMeasurements(pulseMeasurements));
    }
}
