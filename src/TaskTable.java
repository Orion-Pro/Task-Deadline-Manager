import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class TaskTable {

    public ArrayList<Task> tasks = new ArrayList<>();
    public HashMap<Integer, Task> tasksByID = new HashMap<>();
    public HashMap<LocalDate, LinkedList<Task>> tasksByDueDate = new HashMap<>();


    public void addTask(Task task) {
        tasks.add(task);
        tasksByID.put(task.getId(), task);

        if (tasksByDueDate.get(task.getDateInfo().getDueDate()) == null)
            tasksByDueDate.put(task.getDateInfo().getDueDate(), new LinkedList<>());

        tasksByDueDate.get(task.getDateInfo().getDueDate()).add(task); //Adds to the linked list;
    }
//
//    public void viewOverdueTasks() {
//        LocalDate today = LocalDate.now();;
//        while (tasksByDueDate.get()) {}
//    }
}
