# Monadic calculator [HARD]

## Description
Here you need to implement a simple monadic-like calculator to apply the principles you've recently learned. The calculator should be resistant to errors and must not throw an exception if something is wrong.

It provides three public methods you should implement.

- The static `of` method creates a new instance of the calculator with a specified initial value; it is an implementation of the `unit` operation.
- The `eval` method applies a given function to the value stored in the calculator. The method returns a new monad that is obtained after applying the given function to the value; it is an implementation of the `map` operation.
- The `consume` method passes the stored value to a given consumer only if no errors have occurred in the calculator and, otherwise, it does nothing.

All of the above methods return calculators (new instances or the same one) following [the builder style](https://dzone.com/articles/design-patterns-the-builder-pattern).

In some cases, the calculator can be broken, e.g. when the stored value become `null` or the `ArithmeticException` (division by zero) occurs inside the `eval` method. In such cases, the calculator shouldn't throw NPE or the `ArithmeticException`. Instead, the special monad called `BROKEN_CALCULATOR` should be returned as the result.

Note that this monadic calculator is just a simplified monad (a monadic-like structure) and it doesn't even provide an analogue of the `flatMap` method. However, it's enough to get the basic principles of working with monads in Java. If you understand this calculator, it will be easy for you to work with the standard monads in Java because they follow the same principles.

To simplify the task, we have written a template for your solution with a set of private fields and methods you can use. We also marked all the methods you need to implement with the comment `// Implement this method`.

Please, do not remove the `final` keyword from the fields. This is functional programming - your monads must be **immutable**.

## Examples
To make it clearer what to do, there are several examples how to interact with the monadic calculator from client code. Look at the examples, they never throw exceptions!

```console
Calculator.of(10) // inits calculator with the default value 10
.consume(System.out::println)  // shows the current value 10
.eval(value -> value * 10)     // evaluates a new expression: 100
.eval(value -> value + 5)      // evaluates a new expression: 105
.consume(System.out::println)  // shows the current value 105
.eval(value -> value / 0)      // provokes an error
.consume(System.out::println); // doesn't print anything

Calculator.of((Integer) null) // inits calculator with null as the default value
.eval(value -> value * 10)     // doesn't evaluate anything
.eval(value -> value + 5)      // doesn't evaluate anything
.consume(System.out::println); // doesn't print anything

Calculator.of(10) // init calculator with the default value 10
.eval(value -> value + 5)      // evaluates a new expression: 15
.consume(System.out::println)  // shows the current value 15
.eval(value -> null) // makes the value null
.consume(System.out::println); // doesn't print anything
```

As a result, all these lines print only three numbers:

```console
10
105
15
```

In our tests, we will set only the default value to the calculator. All other steps will be the same.

This is roughly how working with monads look like. Any side effects such as exceptions are hidden inside it, but depending on a monad changes its behavior. But in real programs, monads are much more complicated, and as a rule, the consumer is not `System.out::println`.

## Tags
- hard
- applying functions to collections and monads
- what is a monad