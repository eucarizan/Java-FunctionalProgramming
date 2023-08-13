# Replacing digits of a number

## Description
In this task, you need to write your own rule and pass it to the `substitution` method to replace the digits of a number. The definition is exactly the same as shown in the previous step.

```java
public static int substitution(long n, Function<Integer, Integer> digitRule)
```

The rule should act as the following:

- if the digit is `5`, it should replace it with `1`;
- if the digit is `6`, it should replace it with `2`;
- if the digit is `7`, it should replace it with `3`;
- if the digit is `8`, it should replace it with `4`;
- if the digit is `9`, it should replace it with `5`;
- any other digits shouldn't be replaced.

There is a whole variety of ways to contrive this rule. The shorter your solution, the better! :)

Note that the `substitution` method belongs to the `Utils` class.

## Examples
**Sample Input:**
```console
12765
```

**Sample Output:**
```console
12321
```

## Tags
- functional interfaces and their applications
- lambda expressions