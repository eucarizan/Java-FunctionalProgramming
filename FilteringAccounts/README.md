# Filtering accounts [HARD]

## Description
In this exercise, you need to write some code with predicates to filter a list of account objects (`List<Account>`) in two different ways.

Here is the definition of the `Account` class:

```java
class Account {
private String number;
private long balance;
private boolean locked;

    // constructor, getters and setters
}
```

There is also a method that can filter the list `filter(List<T> elems, Predicate<T> predicate)`. It takes a list and a predicate containing the filtering condition.

Write code for filtering the `accounts` list using the `filter` method in two ways:

1. get **all non-empty** accounts (`balance` > 0) and save it to the variable `nonEmptyAccounts`
2. get **all non-locked** accounts **with too much money** (`balance` >= 100 000 000) and save it to the variable `accountsWithTooMuchMoney`

Use the given code template for your solution. Please, do not change it.

There is an example of using the `filter` method. The code below gets only even numbers from a list.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
List<Integer> evenNumbers = filter(numbers, number -> number % 2 == 0); // 2, 4, 6
```

## Tags
- hard
- functional interfaces and their implementations
- standard functional interfaces
- predicates