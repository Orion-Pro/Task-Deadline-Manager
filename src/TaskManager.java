import java.util.ArrayList;
import java.util.Collections; //Very useful for array lists

public class TaskManager {

    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void displayTasks() {
        if (tasks.size() == 0) {
            System.out.println("There are currently no tasks to do.");
            return;
        }

        this.sortTasks();
        System.out.printf("%-5s, %-12s, %-18s, %-12s, %-10s%n", "ID", "Title", "Description", "Due Date", "Status");
        for (Task t : tasks)
            t.displayTaskRow();

    }

    private void viewOverdueTasks() {
        for (Task t : tasks) {
            if (t.getDateInfo().isOverdue())
                System.out.println(t + " - ");
        }
    }

    public void removeCompletedTasks() {}

    public void saveToFile() {}

    public void loadFromFile() {}

    public void sortTasks() {
        Collections.sort(tasks);
    }

    public Task searchByID(int ID) {
        for (Task t : tasks) {
            if (t.getId() == ID)
                return t;
        }
        return null;
    }

}
