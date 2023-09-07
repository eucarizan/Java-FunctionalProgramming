import java.util.List;

public class HealthChecker {
    public static boolean checkPulseMeasurements(List<Integer> pulseMeasurements) {
        if (pulseMeasurements == null) {
            throw new NullPointerException();
        }

        return pulseMeasurements.stream()
                .allMatch(bpm -> bpm >= 90 && bpm <= 150);
    }
}
