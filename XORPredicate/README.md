# The exclusive OR Predicate

## Description
There is a well known logical operation called **exclusive or** (or simply, **xor**) that is often used in low-level programming and crypto algorithms. The rule for this operation is very simple: it returns `true` only if both boolean operands are different, otherwise, it returns `false`.

Java provides this operation for boolean expressions and it is denoted as `^`. However the predicates do not provide this operation for composition.

In this task you need to create the `xor` operation using all of `and`, `or` and `not`. There are several ways how to get it but the simplest one is just to follow the formula: `A or B, but not(A and B)`.

If you need to test your code locally, just create a couple of predicates and try to combine them to get the `xor` predicate.

## Examples
**Sample Input:**
```console
false false
```

**Sample Output:**
```console
false
```

## Tags
- functional interfaces and their implementations
- composition of functions
- predicates