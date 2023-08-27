import java.util.Optional;

public class User {
    private String login;
    private Account account;

    public User(String login, Account account) {
        this.login = login;
        this.account = account;
    }

    public String getLogin() {
        return login;
    }

    public Optional<Account> getAccount() {
        return Optional.ofNullable(account);
    }

    @Override
    public String toString() {
        return "user account: " + account;
    }
}
