import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testLogs_NormalCase; " +
                    "2023-09-07T09:22:14.911233500Z|ERROR|100, 2023-09-07T09:23:25.328682300Z|WARN|200, 2023-09-07T09:23:40.918435400Z|INFO|300;" +
                    "INFO;" +
                    "{2023-09-07T09:22:14.911233500Z=Log {type='ERROR', delay=100}, 2023-09-07T09:23:25.328682300Z=Log {type='WARN', delay=200}}",
            "testLogs_EmptyLogs ; " +
                    "''; " +
                    "INFO; " +
                    "{}",
            "testLogs_NoLogsMatchingFilter; " +
                    "2023-09-07T09:22:14.911233500Z|DEBUG|100, 2023-09-07T09:23:25.328682300Z|TRACE|200;" +
                    "INFO; " +
                    "{2023-09-07T09:22:14.911233500Z=Log {type='DEBUG', delay=100}, 2023-09-07T09:23:25.328682300Z=Log {type='TRACE', delay=200}}",
            "testLogs_NullLogTypeToFilter; " +
                    "2023-09-07T09:22:14.911233500Z|ERROR|100, 2023-09-07T09:23:25.328682300Z|WARN|200, 2023-09-07T09:23:40.918435400Z|INFO|300;" +
                    "; " +
                    "{2023-09-07T09:22:14.911233500Z=Log {type='ERROR', delay=100}, " +
                    "2023-09-07T09:23:40.918435400Z=Log {type='INFO', delay=300}, " +
                    "2023-09-07T09:23:25.328682300Z=Log {type='WARN', delay=200}}",
            "testLogs_AllLogsMatchTypeToFilter; " +
                    "2023-09-07T09:22:14.911233500Z|WARN|100, 2023-09-07T09:23:25.328682300Z|WARN|200, 2023-09-07T09:23:40.918435400Z|WARN|300; " +
                    "WARN; " +
                    "{}",
            "testLogs_CollisionMultipleLogsWithSameTimeStamp; " +
                    "2023-09-07T09:22:14.911233500Z|ERROR|100, 2023-09-07T09:22:14.911233500Z|ERROR|200, 2023-09-07T09:22:14.911233500Z|INFO|300; " +
                    "WARN;" +
                    "{2023-09-07T09:22:14.911233500Z=Log {type='ERROR', delay=100}}",
            "testLogs_LargeDelayValues; " +
                    "2023-09-07T09:22:14.911233500Z|ERROR|10000, 2023-09-07T09:23:25.328682300Z|INFO|50000, 2023-09-07T09:23:40.918435400Z|ERROR|30000; " +
                    "INFO;" +
                    "{2023-09-07T09:22:14.911233500Z=Log {type='ERROR', delay=10000}, 2023-09-07T09:23:40.918435400Z=Log {type='ERROR', delay=30000}}",
    }, delimiter = ';')
    public void test(String name, String input, String typeToFilter, String expected) {
        List<Log> param;

        if (input == null || input.isEmpty()) {
            param = List.of();
        } else {
            param = Arrays.stream(input.split(", "))
                    .map(s -> s.split("\\|"))
                    .map(parts -> new Log(Instant.parse(parts[0]), parts[1], Long.parseLong(parts[2])))
                    .toList();
        }

        String result = FilterLogs.notInfoLogs(param, typeToFilter).toString();

        assertEquals(expected, result);
    }
}
