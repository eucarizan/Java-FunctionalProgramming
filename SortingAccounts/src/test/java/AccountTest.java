import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AccountTest {

    @Test
    public void givenAccountsWhenAddedAndSortedThenExpectSortedByLockedBalanceDESCOwner() {
        List<String> expected = List.of(
                "Helen 5000 false",
                "John 1000 false",
                "Peter 1000 false",
                "Ivan 8000 true",
                "Nicole 3000 true"
        );

        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account("Peter", 1000L, false));
        accounts.add(new Account("John", 1000L, false));
        accounts.add(new Account("Ivan", 8000L, true));
        accounts.add(new Account("Helen", 5000L, false));
        accounts.add(new Account("Nicole", 3000L, true));

        accounts.sort(Account.getComparatorByLockedBalanceAndOwner());

        List<String> accountsStr = new ArrayList<>();

        accounts.forEach(account -> accountsStr.add(account.toString()));

        Assert.assertEquals(expected, accountsStr);
    }

}