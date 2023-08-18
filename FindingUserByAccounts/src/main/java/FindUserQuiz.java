import java.util.Optional;
import java.util.Set;

public class FindUserQuiz {

    public static Optional<User> findUserByAccountId(Set<User> users, String id) {
        // write your code here
        User user = null;

        for (User u : users) {
            if (u.getAccount().isPresent() && u.getAccount().get().getId().equals(id)) {
                user = u;
            }
        }

        return Optional.ofNullable(user);
    }
}