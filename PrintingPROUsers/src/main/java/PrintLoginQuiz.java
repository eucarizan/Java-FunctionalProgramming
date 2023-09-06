import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class PrintLoginQuiz {
    public static void printLoginIfPro(Set<User> users, String id) {
        users.forEach(
                user -> Optional
                        .ofNullable(user)
                        .flatMap(User::getAccount)
                        .filter(account -> account.getId().equals(id) && "pro".equals(account.getType()))
                        .ifPresent(u -> System.out.println(user.getLogin()))
        );

//        users.stream()
//                .filter(user -> user.getAccount().isPresent() && user.getAccount().get().getId().equals(id))
//                .filter(user -> user.getAccount().get().getType().equalsIgnoreCase("pro"))
//                .map(User::getLogin)
//                .forEach(System.out::println);
    }

    public static void printLoginIfProNJ(Set<User> users, String id) {
        users.forEach(user -> {
            if (user.getAccount().isPresent()) {
                if (Objects.equals(user.getAccount().get().getId(), id) && "pro".equals(user.getAccount().get().getType())) {
                    System.out.println(user.getLogin());
                }
            }
        });
    }
}
