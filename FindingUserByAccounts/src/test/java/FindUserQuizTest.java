import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class FindUserQuizTest {

    static Set<User> userSet = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        Account account1 = new Account("account1");
        Account account2 = new Account("account2");
        Account account3 = new Account("account3");
        userSet.add(new User("User1", account1));
        userSet.add(new User("User2", account2));
        userSet.add(new User("User3", account3));
    }

    @Test
    public void givenAccountPresentWhenUserSearchThenExpectUserIsReturned() {
        Assert.assertEquals("Optional[User: User1 has account: true]",
                FindUserQuiz.findUserByAccountId(userSet, "account1").toString());
    }

    @Test
    public void givenAccountNotPresentWhenUserSearchThenExpectOptionalEmptyIsReturned() {
        Assert.assertEquals("Optional.empty",
                FindUserQuiz.findUserByAccountId(userSet, "account4").toString());
    }

}