# The total number of employees [HARD]

## Description
Imagine, you are collaborating to develop an employee management system for your company. The system has two domain classes:

```java
class Employee {
private final String name;
private final Long salary;

    // constructor and getters
}

class Department {
private final String name;
private final String code;
private final List<Employee> employees;

    // constructor and getters
}
```

Both classes have getters for all fields with the corresponding names (`getName()`, `getSalary()`, `getEmployees()` and so on).

Your task is to implement a method that calculates **the total number of employees** with `salary >= threshold` for all departments whose code starts with the string `"111-"` (without `""`). Try to apply your knowledge of the Stream API and especially the `flatMap` method to provide the implementation.

**An example**: there is a list containing two departments and the threshold is 20 000.

```java
List<Department> departments = List.of(
    new Department("dep-1", "111-1", List.of(
        new Employee("William", 15000L),
        new Employee("Sophia", 22000L),
        new Employee("John", 20000L)
    )),
    new Department("dep-2", "222-1", List.of(
        new Employee("Victor", 25000L)
    ))
);
```

The result is 2 because there are two people from the `"dep-1"` department  (the code starts with `"111-"`) who have `salary >= 20000` (`"Sophia"` and `"John"`). The employee named `"Victor"` is not counted because his department doesn't start with this code.

This code challenge is also used [on the Hyperskill / JetBrains Academy platform.](https://hyperskill.org/learn/step/2447)

## Tags
- data processing with streams
- transform elements