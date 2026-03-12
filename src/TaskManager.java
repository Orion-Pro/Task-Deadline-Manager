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

    private void viewOverdueTasks() {
        for (Task t : tasks) {
            if (t.getDateInfo().isOverdue())
                System.out.println(t + " - ");
        }
    }

    public void removeCompletedTasks() {}

    public void saveToFile() {}

    public void loadFromFile() {}

    public void mergeSort() {
        tasks.sort();
    }

    public Task searchByID(int ID) {
        for (Task t : tasks) {
            if (t.getId() == ID)
                return t;
        }
        return null;
    }

}
