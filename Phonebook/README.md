# Phonebook

## Description
In this code challenge, you will work with the methods of the `Map` interface to support adding new phone numbers into a phonebook.

The numbers are represented by a class named `PhoneNumber` comprising only two fields:

```java
class PhoneNumber {
private PhoneNumberType type;
private String number;

    // constructor and getters
}
```

The `PhoneNumberType` enum determines the type of the number.

```java
enum PhoneNumberType {
MOBILE, HOME, WORK,
}
```

The phonebook is a class based on a map where keys are names and values are lists of phone numbers because each person can have multiple phone numbers. Here is the definition of the map:

```java
class PhoneBook {
private final Map<String, Collection<PhoneNumber>> nameToPhoneNumbersMap = new HashMap<>();

    // methods
}
```

To solve this problem, you need to implement two methods of the `PhoneBook` class.

- The `addNewPhoneNumbers` method should add given phone numbers to the list of the numbers for a specified person by the name. If the name is not yet in the phonebook, then it must appear in it with the given numbers.
- the `printPhoneBook` should print all numbers with their types for each name in the phonebook. The output example is presented below the example.

Here is an example of using both these methods:

```java
PhoneBook phoneBook = new PhoneBook();

List<PhoneNumber> claraPhoneNumbers = new ArrayList<>();
claraPhoneNumbers.add(new PhoneNumber(PhoneNumberType.HOME, "723324324"));
phoneBook.addNewPhoneNumbers("Clara", claraPhoneNumbers);

List<PhoneNumber> kevinPhoneNumbers = new ArrayList<>();
kevinPhoneNumbers.add(new PhoneNumber(PhoneNumberType.WORK, "1231"));
phoneBook.addNewPhoneNumbers("Kevin", kevinPhoneNumbers);

phoneBook.addNewPhoneNumbers("Clara", List.of(new PhoneNumber(PhoneNumberType.MOBILE, "23424279")));
phoneBook.addNewPhoneNumbers("Paul", List.of(new PhoneNumber(PhoneNumberType.WORK, "56756335")));

phoneBook.printPhoneBook();
```

After executing this code, if everything is OK, your program must print:

```console
Kevin
WORK: 1231
Clara
HOME: 723324324
MOBILE: 23424279
Paul
WORK: 56756335
```

Pay attention that some of the given collections of numbers may be immutable. Your solution should not crash in this case.

There are many ways to solve this problem and you can choose any of them, but be sure to use lambda expressions or methods references and the methods you've just learned.

## Examples
**Sample Input:**
```console
No input
```

**Sample Output:**
```console
Kevin
WORK: 1231
Clara
HOME: 723324324
MOBILE: 23424279
Paul
WORK: 56756335
```

## Tags
- applying functions to collections and monads
- handling collections with functions
- maps