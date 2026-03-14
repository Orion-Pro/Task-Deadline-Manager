import java.util.Collections; //Very useful for array lists


public class TaskManager {

    public static String Error_Message = "An unexpected error has occured.";

    TaskTable taskTable = new TaskTable();

    public void displayTasks() {
        if (taskTable.tasks.isEmpty()) {
            System.out.println("There are currently no tasks to do.");
            return;
        }

        this.sortTasks();
        System.out.printf("%-5s %-12s %-20s %-12s %-10s%n", "ID", "Title", "Description", "Due Date", "Status");
        for (Task t : taskTable.tasks)
            t.displayTaskRow();

    }

    public void removeCompletedTasks() {}

    public void saveToFile() {}

    public void loadFromFile() {}

    public void sortTasks() {
        Collections.sort(taskTable.tasks);
    } //Might not need to sort, get back to it later.

    public Task searchByID(int ID) {
        try {
            return taskTable.tasksByID.get(ID);
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("Task does not exist.");
            return null; //Required because this exception should not terminate the program.
        }
        catch(Exception e) {
            System.out.println(Error_Message);
        }
        return null;
    }
}
