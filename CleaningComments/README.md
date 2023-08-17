# Cleaning comments

## Description
One social network platform is undergoing major changes. The management decided to clean up all the old comments and also reduce the max comment length to save computer resources. As a programmer who understands the importance of comments, you decided to get this task.

The platform uses the following simple class to represent comments:

```java
class Comment {
private final Date created;
private final String text;
}
```

You need to implement two methods in the `CommentUtils` class:

- `handleComments` to process a given list of comments by removing old ones (older than `thresholdDate`) and shortening exceeding texts (longer than `maxTextLength`) to the max size (inclusively, i.e. max = 30 -> take only 30 characters).
- `printComments` to every comment on a separate line following the given format (see the examples below).
To do that, we highly recommend you to apply all the methods you've just learned.

Here is an example how the implemented methods should work.

```java
List<Comment> comments = new ArrayList<>();

comments.add(new Comment(
CommentUtils.TEXT_FORMATTER.parse("14-03-2020 10:20:34"),
"What a beautiful photo! Where is it?"
));
comments.add(new Comment(
CommentUtils.TEXT_FORMATTER.parse("16-03-2020 15:35:18"),
"I do not know, I just found it on the internet!"
));
comments.add(new Comment(
CommentUtils.TEXT_FORMATTER.parse("20-03-2020 19:10:22"),
"Is anyone here?"
));

Date threshold = CommentUtils.TEXT_FORMATTER.parse("15-03-2020 00:00:00");
int maxTextLength = 30; // it is just an example, do not rely on this number!

CommentUtils.handleComments(comments, threshold, maxTextLength);
CommentUtils.printComments(comments);
```

This code snippet prints:

```console
[16-03-2020 15:35:18] I do not know, I just found it
[20-03-2020 19:10:22] Is anyone here?
```

As you can see, there is only a single space between the date and the text. Please, use the same format.

Do not forget to check your code for various edge cases. What if the length of a message equals `maxTextLength` or this limit is only 1 character. But we guarantee that this value is greater than 0.

## Examples
**Sample Input:**
```console
15-03-2020 00:00:00 30
14-03-2020 10:20:34 What a beautiful photo! Where is it?
16-03-2020 15:35:18 I do not know, I just found it on the internet!
20-03-2020 19:10:22 Is anyone here?
```

**Sample Output:**
```console
[16-03-2020 15:35:18] I do not know, I just found it
[20-03-2020 19:10:22] Is anyone here?
```

## Tags
- applying functions to collections and monads
- handling collections with functions