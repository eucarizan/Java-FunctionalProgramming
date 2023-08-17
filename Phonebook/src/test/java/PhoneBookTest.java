
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookTest {

    PhoneBook phoneBook;
    List<PhoneNumber> claraPhoneNumbers;
    List<PhoneNumber> kevinPhoneNumbers;
    Map<String, Collection<PhoneNumber>> nameToPhoneNumberMap;

    String expected = """
            Kevin
            WORK: 1231
            Clara
            HOME: 723324324
            MOBILE: 23424279
            Paul
            WORK: 56756335
            """;

    @BeforeEach
    public void beforeTest() {
        phoneBook = new PhoneBook();

        claraPhoneNumbers = new ArrayList<>();
        claraPhoneNumbers.add(new PhoneNumber(PhoneNumberType.HOME, "723324324"));

        kevinPhoneNumbers = new ArrayList<>();
        kevinPhoneNumbers.add(new PhoneNumber(PhoneNumberType.WORK, "1231"));

        nameToPhoneNumberMap = new HashMap<>();
    }

    @Test
    public void addNewPhoneNumbersTest() {
        phoneBook.addNewPhoneNumbers("Clara", claraPhoneNumbers);
        phoneBook.addNewPhoneNumbers("Kevin", kevinPhoneNumbers);
        phoneBook.addNewPhoneNumbers("Clara", List.of(new PhoneNumber(PhoneNumberType.MOBILE, "23424279")));
        phoneBook.addNewPhoneNumbers("Paul", List.of(new PhoneNumber(PhoneNumberType.WORK, "56756335")));

        String result = phoneBook.toString().replaceAll("\r", "");

        assertEquals(expected, result);
    }

    @Test
    public void addNewPhoneNumbersComputeTest() {
        phoneBook.addNewPhoneNumbersCompute("Clara", claraPhoneNumbers);
        phoneBook.addNewPhoneNumbersCompute("Kevin", kevinPhoneNumbers);
        phoneBook.addNewPhoneNumbersCompute("Clara", List.of(new PhoneNumber(PhoneNumberType.MOBILE, "23424279")));
        phoneBook.addNewPhoneNumbersCompute("Paul", List.of(new PhoneNumber(PhoneNumberType.WORK, "56756335")));

        String result = phoneBook.toString().replaceAll("\r", "");

        assertEquals(expected, result);
    }

    @Test
    public void addNewPhoneNumbersMergeTest() {
        phoneBook.addNewPhoneNumbersMerge("Clara", claraPhoneNumbers);
        phoneBook.addNewPhoneNumbersMerge("Kevin", kevinPhoneNumbers);
        phoneBook.addNewPhoneNumbersMerge("Clara", List.of(new PhoneNumber(PhoneNumberType.MOBILE, "23424279")));
        phoneBook.addNewPhoneNumbersMerge("Paul", List.of(new PhoneNumber(PhoneNumberType.WORK, "56756335")));

        String result = phoneBook.toString().replaceAll("\r", "");

        assertEquals(expected, result);
    }
}