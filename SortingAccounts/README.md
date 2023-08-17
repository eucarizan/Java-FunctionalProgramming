# Sorting accounts

## Description
Let's imagine you are working on a banking system that contains information about accounts and their owners. An account is presented by the following class:

```java
class Account {
private final String owner;
private final long balance;
private final boolean locked;

    // constructor, getters, toString
}
```

Here, the `owner` field stores the name of the account's owner, and the `locked` flag determines if the account is locked / disabled.

Now you need to support an ability to sort accounts by their `locked` flag, `balance` and the name of the owner. After sorting, **non-blocked accounts** should be placed before the blocked ones and they must be sorted by balance in descending order. If the balances are the same, the accounts must also be sorted by owner name in lexicographic order. To support this sorting mechanism, just implement the `getComparatorByLockedBalanceAndOwner` method by returning an appropriate comparator.

Here is an example of using the comparator:

```java
List<Account> accounts = new ArrayList<>();

accounts.add(new Account("Peter", 1000L, false));
accounts.add(new Account("John", 1000L, false));
accounts.add(new Account("Ivan", 8000L, true));
accounts.add(new Account("Helen", 5000L, false));
accounts.add(new Account("Nicole", 3000L, true));

accounts.sort(Account.getComparatorByLockedBalanceAndOwner());

accounts.forEach(System.out::println);
```

If everything works as expected, this code should print:

```console
Helen 5000 false
John 1000 false
Peter 1000 false
Ivan 8000 true
Nicole 3000 true
```

Please, do not delete any members of the class.


## Examples
**Sample Input:**
```console
Peter 1000 false
John 1000 false
Ivan 8000 true
Helen 5000 false
Nicole 3000 true
```

**Sample Output:**
```console
Helen 5000 false
John 1000 false
Peter 1000 false
Ivan 8000 true
Nicole 3000 true
```

## Tags
- applying functions to collections and monads
- sorting data with function