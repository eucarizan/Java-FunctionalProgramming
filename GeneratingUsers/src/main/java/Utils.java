import java.util.stream.Stream;

public class Utils {
    public static Stream<User> generateUsers(int numberOfUsers) {
        return Stream.iterate(1, n -> n <= numberOfUsers, n -> n + 1)
                .map(i -> new User(i, "user" + i + "@gmail.com"));
    }
}
