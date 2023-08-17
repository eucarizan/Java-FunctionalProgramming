import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CommentUtils {
    public static final SimpleDateFormat TEXT_FORMATTER = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    private CommentUtils() {}

    public static void handleComments(List<Comment> comments, Date thresholdDate, int maxTextLength) {
        comments.removeIf(comment -> comment.getCreated().before(thresholdDate));
        comments.replaceAll(comment ->
            new Comment(comment.getCreated(), comment.getText().substring(0, Math.min(comment.getText().length(), maxTextLength)))
        );
    }
    public static void printComments(List<Comment> comments) {
        comments.forEach(comment -> System.out.printf("[%s] %s%n", TEXT_FORMATTER.format(comment.getCreated()), comment.getText()));
    }
}
