import java.util.List;

public class XmlFile {
    private final String id;
    private final String encoding;
    private final List<Tag> tags;

    public XmlFile(String id, String encoding, List<Tag> tags) {
        this.id = id;
        this.encoding = encoding;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public String getEncoding() {
        return encoding;
    }

    public List<Tag> getTags() {
        return tags;
    }
}
