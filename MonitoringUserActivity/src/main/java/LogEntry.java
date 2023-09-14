import java.util.Date;

public record LogEntry(Date created, String login, String url) {
}
