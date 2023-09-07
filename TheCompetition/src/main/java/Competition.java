import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Competition {

    public static Map<String, Integer> getTeamPlaceMap(Collection<Team> teams) {
        return teams.stream()
                .sorted(Comparator.comparing(Team::getPlace))
                .collect(Collectors.toMap(Team::getName, Team::getPlace, (v1, v2) -> v1, LinkedHashMap::new));
    }

    public static String getTeamPlaceMapToString(Collection<Team> teams) {
        return getTeamPlaceMap(teams).entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
