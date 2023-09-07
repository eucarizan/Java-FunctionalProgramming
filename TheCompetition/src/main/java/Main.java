import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String input = "Champions|2, Ducks|3, Bright|4, JCoders|1";
        List<Team> teams = Arrays.stream(input.split(", "))
                .map(s -> s.split("\\|"))
                .map(parts -> new Team(parts[0], Integer.parseInt(parts[1])))
                .toList();

        Competition.getTeamPlaceMap(teams)
                .forEach((team, place) -> System.out.printf("%s: %d%n", team, place));
    }
}