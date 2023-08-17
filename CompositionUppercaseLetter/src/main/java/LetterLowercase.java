import java.util.function.Predicate;

public class LetterLowercase {
    private static final Predicate<Character> isLetter = Character::isLetter;
    private static final Predicate<Character> isUpperCase = Character::isUpperCase;

    public static Predicate<Character> predicate = isLetter.and(isUpperCase.negate());
}
