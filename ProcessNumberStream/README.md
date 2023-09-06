# Get Stream Results

## Description
Given a stream containing different numbers:

Stream<Integer> numbers = Stream.of(7, 4, 2, 8, 9, 1, 4, 5, 8, 2);
Match the pipelines and their results.

Feel free to conduct local experiments and debugging if you need to solve this problem.

1.  ```java
    numbers.min(Integer::compareTo).get()
    ```
2. ```java
    numbers.sorted(Collections.reverseOrder()).findFirst().get()
    ```
3. ```java
    numbers.limit(4).max(Integer::compareTo).get()
    ```
4. ```java
    numbers.distinct().skip(6).findAny().get()
    ```

## Tags
- data processing with streams
- introduction to stream api