import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testSample ; Champions|2, Ducks|3, Bright|4, JCoders|1 ; [JCoders: 1, Champions: 2, Ducks: 3, Bright: 4]",
            "testEmptyCollection ; '' ; []",
            "testSingleTeam ; Solo|1 ; [Solo: 1]",
            "testDuplicateTeamPlaces ; JCoders|1, Champions|2, Ducks|2, Bright|4 ; [JCoders: 1, Champions: 2, Ducks: 2, Bright: 4]",
            "testTeamNamesWithSpecialChars ; Team#1|1, Team-2|2, Team@3|3 ; [Team#1: 1, Team-2: 2, Team@3: 3]",
            "test name ; Sample|1 ; [Sample: 1]",
    }, delimiter = ';')
    public void test(String name, String input, String expected) {
        List<Team> param;

        if (input.isEmpty()) {
            param = List.of();
        } else {
            param = Arrays.stream(input.split(", "))
                    .map(s -> s.split("\\|"))
                    .map(parts -> new Team(parts[0], Integer.parseInt(parts[1])))
                    .toList();
        }

        String result = Competition.getTeamPlaceMapToString(param);

        assertEquals(expected, result);
    }

    @Test
    public void testGetTeamPlaceMapToString_LargeNumberOfTeams() {
        List<Team> teams = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            teams.add(new Team("Team " + i, i));
        }

        String result = Competition.getTeamPlaceMapToString(teams);

        // Check the format and a few individual team entries
        assertTrue(result.startsWith("[Team 1: 1, Team 2: 2, Team 3: 3,"));
        assertTrue(result.contains("Team 500: 500"));
        assertTrue(result.contains("Team 1000: 1000"));
    }

    @Test
    public void testGetTeamPlaceMapToString_LongTeamNames() {
        Collection<Team> teams = Arrays.asList(
                new Team("Very Long Team Name A", 1),
                new Team("Team B", 2),
                new Team("Extremely Long Team Name C", 3)
        );

        String result = Competition.getTeamPlaceMapToString(teams);

        assertTrue(result.contains("Very Long Team Name A: 1,"));
        assertTrue(result.contains("Extremely Long Team Name C: 3"));
    }

}
