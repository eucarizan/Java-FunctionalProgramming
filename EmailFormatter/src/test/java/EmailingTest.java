import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailingTest {

    @Test
    public void givenNormalInputWhenFormatEmailThenExpectEmailFormatted() {
        String sender = "sender@mymail.com";
        String receiver = "receiver@mymail.com";
        String signature = "Best regards, James Gosling";
        String message = "The new version of Java works pretty fast!";
        String expected = "sender@mymail.com|receiver@mymail.com|The new version of Java works pretty fast!|Best regards, James Gosling";

        assertThat(Emailing.formatEmail(sender, receiver, signature, message)).isEqualTo(expected);
    }
}