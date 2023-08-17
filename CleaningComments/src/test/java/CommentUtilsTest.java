import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentUtilsTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    // This ensures we don't get any unwanted side effects later on in other tests.
    @After
    public void tearDown() {
        System.setOut(standardOut);
    }


    @Test
    public void givenThreeCommentsWhenOneDoNotPassThresholdThenExpectTwoComments() throws ParseException {
        List<Comment> comments = new ArrayList<>();

        comments.add(new Comment(
                CommentUtils.TEXT_FORMATTER.parse("14-03-2020 10:20:34"),
                "What a beautiful photo! Where is it?"
        ));
        comments.add(new Comment(
                CommentUtils.TEXT_FORMATTER.parse("16-03-2020 15:35:18"),
                "I do not know, I just found it on the internet!"
        ));
        comments.add(new Comment(
                CommentUtils.TEXT_FORMATTER.parse("20-03-2020 19:10:22"),
                "Is anyone here?"
        ));

        Date threshold = CommentUtils.TEXT_FORMATTER.parse("15-03-2020 00:00:00");
        int maxTextLength = 30;

        String expected = "[16-03-2020 15:35:18] I do not know, I just found it[20-03-2020 19:10:22] Is anyone here?";

        CommentUtils.handleComments(comments, threshold, maxTextLength);
        CommentUtils.printComments(comments);

        assertEquals(expected, outputStreamCaptor.toString().replaceAll("\n", "").replaceAll("\r", ""));
    }
}
