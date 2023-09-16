import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} -- range({1}, {2}) == {3}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testCreatePrimesFilteringStream_InRange : 1 : 10 : [2, 3, 5, 7]",
            "testCreatePrimesFilteringStreamEmptyRange : 10 : 1 : []",
            "testCreatePrimesFilteringStreamNegativeRange : -5 : 5 : [2, 3, 5]",
            "testCreatePrimesFilteringStreamSinglePrime : 11 : 11 : [11]",
            "testCreatePrimesFilteringStreamNoPrimesInRange : 25 : 28 : []",
    }, delimiter = ':')
    public void test(String name, int input1, int input2, String expected) {
        String result = Arrays.toString(NumberUtils.createPrimesFilteringStream(input1, input2).toArray());

        assertEquals(expected, result);
    }
}
