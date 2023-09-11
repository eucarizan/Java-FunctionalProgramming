# Reduction-based conjunction

## Description
You probably remember the problem when you had to combine predicates to get the conjunction. It is time to solve it again, but with the use of the reduction.

Here, you need to implement the `conjunctAll` method that accepts a stream of `IntPredicate` objects and returns one composed `IntPredicate`. This predicate must be a **conjunction** of all the input predicates, i.e. it returns `true` only if the input predicates return `true`, otherwise it must be `false`. If the input list is empty, the resulted predicate must return `true` for any integer value (it is also known as **always true predicate**).

## Tags
- data processing with streams
- reduction