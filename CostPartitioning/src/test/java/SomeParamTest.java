import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;
import java.util.Map;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} -- getPartition({1}) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testGetPartitionWithEmptyList : '' : 0 : 0",
            "testGetPartitionWithAllFreeApplications : App1|true, App2|true, App3|true : 3 : 0",
            "testGetPartitionWithAllPaidApplications : App4|false, App5|false, App6|false : 0 : 3",
            "testGetPartitionWithMixedApplications : App7|true, App8|false, App9|true, App10|false : 2 : 2",
    }, delimiter = ':')
    public void test(String name, String input, int expectedTrue, int expectedFalse) {
        List<Application> param;

        if (input.isEmpty()) {
            param = List.of();
        } else {
            param = Arrays.stream(input.split(", "))
                    .map(s -> s.split("\\|"))
                    .map(parts -> new Application(parts[0], Boolean.parseBoolean(parts[1])))
                    .toList();
        }

        Map<Boolean, List<Application>> result = Partitioner.getPartition(param);

        System.out.println(result);

        assertEquals(expectedTrue, result.get(true).size());
        assertEquals(expectedFalse, result.get(false).size());
    }
}
