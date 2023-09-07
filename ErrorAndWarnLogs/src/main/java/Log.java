import java.time.Instant;

public class Log {
    private final Instant timestamp;
    private final String type;
    private final long delay;

    public Log(Instant timestamp, String type, long delay) {
        this.timestamp = timestamp;
        this.type = type;
        this.delay = delay;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getType() {
        return type;
    }

    public long getDelay() {
        return delay;
    }

    @Override
    public String toString() {
        return "Log {type='" + type + '\'' +
                ", delay=" + delay +
                '}';
    }
}
