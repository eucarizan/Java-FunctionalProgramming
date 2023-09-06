# Processing delivery orders [HARD]

## Description
Here you need to apply all your previous knowledge to develop a delivery processing system (oversimplified, of course). In this system, an order is an instance of the `DeliveryOrder` class. It stores a lot of information, but for simplicity we ask you to use only three fields:

- `orderId` that represents a unique identifier of the order;
- `address` that is the place where the order is expected;
- `deliveryDate` that is the date when the order needs to be delivered (only the date, time doesn't matter).

Sometimes, work with the system produces duplicate orders when `orderId` is different, but `address` and `deliveryDate` are the same. Such orders are considered as duplicates.

What exactly you need to do is implement the following two methods.

- The `findFirstOrder` method takes a list of orders and must return the first / the earliest order in the list according to the value of the `deliveryDate` field. If the list is empty, the method must return an order created by its default constructor ("the empty order").
- The `printAddressesToDeliver` method also takes a list of orders and must print addresses sorted by `deliveryDate` (from the earliest to the latest one) without duplicates. Every address must be print on a new line. If the list contains a duplicate, only the first order should be printed to avoid visiting the same address twice.

To help you implement both the methods, we have provided the utility method `DeliveryOrder.getComparatorByDeliveryDate()` that returns the comparator to compare orders by the `deliveryDate` field.

**An example**

Imagine, we have information about the following three orders:

```text
1|2021-09-03|112 Mammoth Street, Colorado Springs, CO 80911
2|2021-09-05|369 Woodside Court, Troy, NY 12180
3|2021-09-02|837 Bowman Street, Helena, MT 59601
4|2021-09-03|112 Mammoth Street, Colorado Springs, CO 80911
```

The first field is `orderId`, the second is `deliveryDate` and the last one is `address`.

In this case, the method `findFirstOrder` must return the order `3|2021-09-02|837 Bowman Street, Helena, MT 59601` because it has the earliest `deliveryDate (2021-09-02)` whereas the method `printAddressesToDeliver` must print the following addresses according to the chronological order and without duplicates:

```console
837 Bowman Street, Helena, MT 59601
112 Mammoth Street, Colorado Springs, CO 80911
369 Woodside Court, Troy, NY 12180
```

We encourage you to use only stream API to solve this task instead of loops or any other approaches. You can also see that we use more advanced features of Stream API to organize input / output here. Right now, this code shouldn't be in your focus, but after completing this module you will easily understand it!

## Examples
**Sample Input:**
```console
1|2021-09-03|112 Mammoth Street, Colorado Springs, CO 80911
2|2021-09-05|369 Woodside Court, Troy, NY 12180
3|2021-09-02|837 Bowman Street, Helena, MT 59601
4|2021-09-03|112 Mammoth Street, Colorado Springs, CO 80911
```

**Sample Output:**
```console
3|2021-09-02|837 Bowman Street, Helena, MT 59601
837 Bowman Street, Helena, MT 59601
112 Mammoth Street, Colorado Springs, CO 80911
369 Woodside Court, Troy, NY 12180
```

## Tags
- data processing with streams
- introduction to stream api