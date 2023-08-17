# IsLetter and IsUpper

## Description
Let's assume that there are two predicates to work with characters:

```java
Predicate<Character> isLetter = Character::isLetter;
Predicate<Character> isUpperCase = Character::isUpperCase;
```

How to compose the predicates so that the new predicate can return the following results?

```java
Predicate<Character> predicate = ... // the composed predicate

predicate.test('1'); // false
predicate.test('3'); // false
predicate.test('c'); // true
predicate.test('D'); // false
predicate.test('e'); // true
predicate.test('Q'); // false
```

There is a hint that the isUppercase method returns false for digits and other non-letter characters.

It is OK if you experiment locally when solving this exercise.

## Tags
- functional interfaces and their implementation
- composition of functions