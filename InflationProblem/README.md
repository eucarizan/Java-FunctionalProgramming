# The inflation problem [HARD]

## Description
Imagine you live in a country that unfortunately has a very high level of economic inflation and some categories of groceries get significantly more expensive every year.

It is known that every year:

- vegetables become 3 times more expensive;
- fruits become 4 times more expensive;
- dairy groceries become 2 times more expensive.

You just got some groceries from a grocery store and you want to predict the price of your purchase after N years. The price of each category of groceries (vegetables, fruits, dairy) depends on its price in the previous year. You can calculate the price in N years using the following formula:

```java
priceInNYears = initialPrice * pow(times, numberOfYears)
```

The categories of groceries are presented by the `Category` enum and the information about groceries is stored in objects of the `Grocery` class. You need to implement the method that calculates the total price of a list of groceries in N years. If the number of years equals to `0`, the result must be the same as if we calculate the price without inflation.

Please, take a look at the examples. The first line contains the number of years after the current year and all the following lines contain the info about one category of groceries.

Try to apply any of the methods learned in this lesson to solve the problem. It can be also useful to declare one or more additional methods to avoid using huge lambda expressions here.

## Examples
**Sample Input 1:**
```console
1
15 VEGETABLES
30 VEGETABLES
10 FRUITS
20 DAIRY
```

**Sample Output 1:**
```console
215
```

**Sample Input 2:**
```console
3
10 FRUITS
20 DAIRY
```

**Sample Output 2:**
```console
800
```

**Sample Input 3:**
```console
0
15 VEGETABLES
```

**Sample Output 3:**
```console
15
```

## Tags
- data processing with streams
- reduction