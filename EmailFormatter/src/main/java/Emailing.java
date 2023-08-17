import java.util.function.Function;

public class Emailing {
    public static String formatEmail(String sender, String receiver, String signature, String message) {
        Function<String, String> emailFormatter = text -> sender + "|" + receiver + "|" + text + "|" + signature;

        return emailFormatter.apply(message);
    }
}
