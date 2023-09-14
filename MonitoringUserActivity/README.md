# Monitoring user activity

## Description
There is a `LogEntry` class for monitoring user activity on a site.

The class has three fields and provides getters for them:

- `created`: is the date of creating log entry;
- `login`: is a string user login;
- `url`: is a string url that the user clicked.

Write a method that leverages **grouping collectors** to calculate how many times each `url` was clicked by users. The collector will be applied to a stream of log entries for creating a map: **url -> click count**.

This code challenge is also used [on the Hyperskill / JetBrains Academy platform](https://hyperskill.org/learn/step/2460).

## Tags
- deep dive into streams
- grouping elements using collectors