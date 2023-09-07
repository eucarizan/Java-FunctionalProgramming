# The competition

## Description
In this exercise, you will help in organizing a competition of projects. There are a lot of teams which take part in this competition and every team presents their own project.

You need to implement the `getTeamPlaceMap` that accepts an unordered collection of teams and returns a map containing team names as keys and their positions as values in the sorted order (from the best to the worst position).

All teams are implemented as objects of the `Team` class and this class provides the team name and the place in the competition. There is also a guarantee that all team names are unique in this competition.

## Examples
**Sample Input:**
```console
Champions 2
Ducks 3
Bright 4
JCoders 1
```

**Sample Output:**
```console
JCoders: 1
Champions: 2
Ducks: 3
Bright: 4
```

## Tags
- data processing with streams
- collecting stream elements