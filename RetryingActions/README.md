# Retrying actions via a method reference [HARD]

## Description
In this exercise, you are going to combine your knowledge of functional interfaces and method references together. There is a method named `retryAction` that accepts an action represented as a Runnable and retries the action with some delay until it is completed successfully or the maximum number of retries is reached.

You need to:

- declare a method called `run` in the `Retry` interface to be able to use this interface with the `retryAction` method;
- assign the method reference to `retryAction` to the retry variable.

## Tags
- hard
- functional interfaces and their implementations
- method references