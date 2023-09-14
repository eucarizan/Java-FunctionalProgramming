import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class XmlUtils {
    public static Map<String, Long> countAllByTagName(List<XmlFile> xmlFiles, String tagName) {
        return xmlFiles.stream()
                .collect(Collectors.groupingBy(XmlFile::getEncoding, Collectors.filtering(
                        xmlFile -> xmlFile.getTags().stream().anyMatch(tag -> tag.getName().equals(tagName)),
                        Collectors.flatMapping(xmlFile -> xmlFile.getTags().stream(), Collectors.counting())
                )));
    }
}
