import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

enum PhoneNumberType {
    MOBILE, HOME, WORK,
}

class PhoneNumber {
    private PhoneNumberType type;
    private String number;

    public PhoneNumber(PhoneNumberType type, String number) {
        this.type = type;
        this.number = number;
    }

    public PhoneNumberType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }
}

class PhoneBook {
    private final Map<String, Collection<PhoneNumber>> nameToPhoneNumbersMap = new HashMap<>();

    public void addNewPhoneNumbers(String name, Collection<PhoneNumber> numbers) {
        nameToPhoneNumbersMap.putIfAbsent(name, new ArrayList<>());
        numbers.forEach(number -> nameToPhoneNumbersMap.get(name).add(number));
    }

    public void addNewPhoneNumbersCompute(String name, Collection<PhoneNumber> numbers) {
        nameToPhoneNumbersMap.computeIfAbsent(name, k -> new ArrayList<>()).addAll(numbers);
    }

    public void addNewPhoneNumbersMerge(String name, Collection<PhoneNumber> numbers) {
        nameToPhoneNumbersMap.merge(name, numbers, (phoneNumbers, phoneNumbers2) -> {
            phoneNumbers.addAll(phoneNumbers2);
            return phoneNumbers;
        });
    }

    public void printPhoneBook() {
        nameToPhoneNumbersMap.forEach((name, number) -> {
            System.out.println(name);
            number.forEach(n -> {
                System.out.printf("%s: %s%n", n.getType(), n.getNumber());
            });
        });
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        nameToPhoneNumbersMap.forEach((name, number) -> {
            sb.append(name).append(System.lineSeparator());
            number.forEach(n -> sb.append(n.getType()).append(": ").append(n.getNumber()).append(System.lineSeparator()));
        });
        return sb.toString();
    }
}