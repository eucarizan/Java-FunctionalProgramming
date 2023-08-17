import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filter {
    public static void printFilteredAccounts(List<Account> accounts) {
        // write your code here
        List<Account> nonEmptyAccounts = filter(accounts, a -> a.getBalance() > 0);
        List<Account> accountsWithTooMuchMoney = filter(accounts, a -> !a.isLocked() && a.getBalance() >= 100_000_000);

        // Please, do not change the code below
        System.out.println("non empty accounts:");
        nonEmptyAccounts.forEach(a -> System.out.print(a.getNumber() + " "));
        System.out.println("\naccounts with too much money:");
        accountsWithTooMuchMoney.forEach(a -> System.out.print(a.getNumber() + " "));
    }

    public static <T> List<T> filter(List<T> elems, Predicate<T> predicate) {
        return elems.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
