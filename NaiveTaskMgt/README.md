# Naive task management

## Description
Imagine that there is a program that handles multiple queues of tasks. Every queue has a priority. The program takes a new task from the highest priority queue (the highest priority is 0) and the algorithm picks the next task using the simple rule: it always takes a new task from the highest priority queue (the highest priority is 0).

The class for the tasks is pretty simple and actually you almost don't need to think about it.

```java
class Task {
private final long number;
private final int priority;

    // constructor and getters
}
```

You need to implement a supplier that returns the next task from the highest priority queue. If the queue is empty, the supplier should return a task from the next queue. The tasks of the same priority must be returned in the same order as they were added to the queue. To do that, modify the `getTaskSupplier` method in the `TaskManager` class to create a supplier producing tasks in a correct order.

## Examples
**Sample Input 1:**
```console
2
2
3000 1
4000 0
```

**Sample Output 1:**
```console
4000
3000
```

**Sample Input 2:**
```console
5
10
1000 0
2000 4
500 1
600 2
800 4
700 4
300 2
200 1
250 2
340 3
```

**Sample Output 2:**
```console
1000
500
200
600
300
250
340
2000
800
700
```

## Tags
- functional interfaces and their implementation
- standard functional interfaces
- predicates
- suppliers