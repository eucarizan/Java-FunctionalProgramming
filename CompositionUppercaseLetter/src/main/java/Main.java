import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Character> isLetter = Character::isLetter;
        Predicate<Character> isUpperCase = Character::isUpperCase;

        Predicate<Character> predicate = isLetter.and(isUpperCase.negate());

        print(predicate.test('1'));
        print(predicate.test('3'));
        print(predicate.test('c'));
        print(predicate.test('D'));
        print(predicate.test('e'));
        print(predicate.test('Q'));
    }

    private static void print(boolean test) {
        System.out.println(test);
    }
}
