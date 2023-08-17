# A ternary predicate

## Description
As the standard functional interfaces cannot have more than two parameters, sometimes they may not be sufficient. Here you need to declare your own functional interface called `TernaryIntPredicate` and use it with a lambda expression. The interface must have a single non-static (and non-default) method `test` accepting three integer arguments and returning a boolean result.

You also need to write a lambda expression that conforms this interface. The lambda expression should return `true` only if all passed values are different. The lambda must be assigned to a variable named `allValuesAreDifferentPredicate` which is a static field.

**Note that** it is possible solve this task using either `Integer` or `int` arguments, but please do not compare references using `!=` or `==`.

## Examples
**Sample Input 1:**
```console
1 1 1
```

**Sample Output 1:**
```console
False
```

**Sample Input 2:**
```console
2 3 4
```

**Sample Output 2:**
```console
True
```

**Sample Input 3:**
```console
3 3 4
```

**Sample Output 3:**
```console
False
```

## Tags
- functional interfaces and their implementation
- standard functional interfaces
- predicates