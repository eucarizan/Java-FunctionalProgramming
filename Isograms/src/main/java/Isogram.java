public class Isogram {
    public static boolean isIsogram(String word) {
        return word.length() == word.chars().distinct().count();
    }
}
