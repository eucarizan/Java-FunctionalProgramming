# Medical software

## Description
Imagine, you are developing software to check health. It gathers the pulse rate of a patient multiple times a day and periodically checks the data. There are different acceptable ranges for the pulse rate, but in this software, the range **90-150 bpm** is considered as good.

You need to implement the method `checkPulseMeasurements` that returns `true` if all pulse measurements are in the acceptable range. If at least one measurement is outside the range, the method must return false for further analysis.

We encourage you to use stream API and the methods you have learned in this lesson to solve this task.

## Examples
**Sample Input 1:**
```console
90 93 100 107 110 105
```

**Sample Output 1:**
```console
true
```

**Sample Input 2:**
```console
130 135 142 147 151 144
```

**Sample Output 2:**
```console
false
```

## Tags
- data processing with streams
- finding and matching elements