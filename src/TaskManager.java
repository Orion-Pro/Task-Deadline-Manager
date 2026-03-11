import java.util.ArrayList;

public class TaskManager {

    private ArrayList<Task> tasks;

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void displayTasks() {
        for (Task t : tasks)
            System.out.print(t + " - ");
    }

    public void removeCompletedTasks() {}

    public void saveToFile() {}

    public void loadFromFile() {}

    public Task searchByID() {}

}
