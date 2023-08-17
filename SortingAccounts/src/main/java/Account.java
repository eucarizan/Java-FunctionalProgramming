import java.util.Comparator;

public class Account {
    private final String owner;
    private final long balance;
    private final boolean locked;

    Account(String owner, long balance, boolean locked) {
        this.owner = owner;
        this.balance = balance;
        this.locked = locked;
    }

    public static Comparator<Account> getComparatorByLockedBalanceAndOwner() {
        // write your code here
        return Comparator.comparing(Account::isLocked)
                .thenComparing(Account::getBalance, Comparator.reverseOrder())
                .thenComparing(Account::getOwner);
    }

    public String getOwner() {
        return owner;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isLocked() {
        return locked;
    }

    @Override
    public String toString() {
        return owner + " " + balance + " " + locked;
    }
}
