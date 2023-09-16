# Prime numbers

## Description
You need to create a prepared parallel `LongStream` for filtering prime numbers in the given range (inclusive both borders). After calling the `count()` method it should return the count of prime numbers in the given range. Please, take a look at the template of the method.

The static method `NumberUtils.isPrime(someLong)` is already declared. It returns `true` if the passed value is prime and `false` otherwise.

Be careful with the `rangeClosed`, `iterate` and `limit` methods. Misuse of them may lead to errors.

Note, that it is not the most efficient approach for generating prime numbers, but it's a good example of using parallel streams.

This code challenge is also used [on the Hyperskill / JetBrains Academy platform](https://hyperskill.org/learn/step/8423).

## Tags
- deep dive into streams
- parallel streams

## Code
- [solution class](./src/main/java/NumberUtils.java)
- [unit tests](./src/test/java/SomeParamTest.java)