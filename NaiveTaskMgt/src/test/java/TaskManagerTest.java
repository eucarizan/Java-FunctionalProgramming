import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskManagerTest {

    @Test
    public void givenTwoTaskTwoPriorityThenExpectTaskManaged() {
        int numberOfQueues = 2;
        long number1 = 3000;
        int priority1 = 1;
        long number2 = 4000;
        int priority2 = 0;

        TaskManager manager = new TaskManager(numberOfQueues);
        Task task1 = new Task(number1, priority1);
        Task task2 = new Task(number2, priority2);
        manager.add(task1, priority1);
        manager.add(task2, priority2);

        Supplier<Task> taskSupplier = manager.getTaskSupplier();
        List<Long> tasksNumbers = new ArrayList<>();
        Task task;
        while ((task = taskSupplier.get()) != null) {
            tasksNumbers.add(task.getNumber());
        }

        List<Long> expected = List.of(4000L, 3000L);

        assertThat(tasksNumbers).isEqualTo(expected);
    }

    @Test
    public void given10Task5PriorityThenExpectTaskManaged() {
        int numberOfQueues = 5;

        String[] inputs = {
                "1000 0",
                "2000 4",
                "500 1",
                "600 2",
                "800 4",
                "700 4",
                "300 2",
                "200 1",
                "250 2",
                "340 3"
        };

        TaskManager manager = new TaskManager(numberOfQueues);

        for (String input : inputs) {
            String[] taskParts = input.split(" ");
            long number = Long.parseLong(taskParts[0]);
            int priority = Integer.parseInt(taskParts[1]);
            Task task = new Task(number, priority);
            manager.add(task, priority);
        }

        Supplier<Task> taskSupplier = manager.getTaskSupplier();

        List<Long> tasksNumbers = new ArrayList<>();
        Task task;
        while ((task = taskSupplier.get()) != null) {
            tasksNumbers.add(task.getNumber());
        }

        List<Long> expected = List.of(1000L, 500L, 200L, 600L, 300L, 250L, 340L, 2000L, 800L, 700L);

        assertThat(tasksNumbers).isEqualTo(expected);
    }
}