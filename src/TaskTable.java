import java.util.ArrayList;

public class TaskTable {

    private ArrayList<Task> dueTasks = new ArrayList<>();
    private ArrayList<Task> overdueTasks = new ArrayList<>();

    public void addDueTask(Task task) {
        dueTasks.add(task);
    }

    public void addOverdueTask(Task task) {
        overdueTasks.add(task);
    }

    public void viewOverdueTasks() {
        for (Task t : overdueTasks) {
            if (t.getDateInfo().isOverdue())
                System.out.println(t + " - ");
        }
    }

}
