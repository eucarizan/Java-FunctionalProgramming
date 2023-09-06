import java.util.List;
import java.util.stream.Stream;

public class NumberStreamProcess {
    public static int[] getResults(Stream<Integer> stream) {
        List<Integer> list = stream.toList();
        int[] nums = new int[4];

        nums[0] = list.stream().min(Integer::compareTo).orElse(0);
        // from stepik
        // nums[1] = numbers.sorted(Collections.reverseOrder()).findFirst().get()
        nums[1] = list.stream().max(Integer::compareTo).orElse(0);
        nums[2] = list.stream().limit(4).max(Integer::compareTo).orElse(0);
        nums[3] = list.stream().distinct().skip(6).findAny().orElse(0);

        return nums;
    }
}
