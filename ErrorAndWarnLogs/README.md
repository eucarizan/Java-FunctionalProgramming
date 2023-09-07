# Producing maps sample

## Description
You need to get a map of `ERROR` and `WARN` logs with timestamps as keys and the `Log` objects as values

## Examples
```java
List<Log> logs = List.of(
new Log(Instant.now(), "ERROR", 100L),
new Log(Instant.now(), "WARN", 200L),
new Log(Instant.now(), "INFO", 300L)
);
```

```console
{2023-09-07T09:22:14.911233500Z=Log {type='ERROR', delay=100}, 2023-09-07T09:23:25.328682300Z=Log {type='WARN', delay=200}}
```

## Tags
- data processing with streams
- collecting stream element