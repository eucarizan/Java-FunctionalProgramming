import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class FilterTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Test
public void printFilteredAccounts() {
        List<Account> accounts = List.of(
                new Account("1", 5000, true),
                new Account("2", 5000, false),
                new Account("3", 0, true),
                new Account("4", 0, false),
                new Account("5", 1_000_000_005, false),
                new Account("6", 1_000_000_005, true)
        );

        System.setOut(new PrintStream(outputStream));

        String expected = "non empty accounts:1 2 5 6 accounts with too much money:5 ";

        Filter.printFilteredAccounts(accounts);

        Assert.assertEquals(expected, outputStream.toString().replaceAll("\n", "").replaceAll("\r", ""));
    }
}