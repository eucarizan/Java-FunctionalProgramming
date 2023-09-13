# Cost partitioning

## Description
There is a class that represents a software application:

```java
class Application {
private final String name;
private final boolean isFree;

    // constructor and getters
}
```

Complete the `getPartition` method that produces two partitions: free applications and paid ones. The partitions should be organized into a `Map` that contains free application by the `true` key and paid ones by the `false` key.

## Tags
- deep dive into streams
- grouping elements using collectors