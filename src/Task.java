public class Task {

    private final int id;
    private final String title;
    private final String description;
    private boolean completed; //not final, because it is changed when completed.
    private final TaskDateInfo dateInfo;

    public Task(int ID, String TITLE, String DES, boolean COMP, TaskDateInfo DI) {
        this.id = ID;
        this.title = TITLE;
        this.description = DES;
        this.completed = COMP;
        this.dateInfo = DI;
    }

    public int compareTo(Task task1, Task task2) {
        if (task1.getDateInfo().dueDate.isBefore(task2.getDateInfo().dueDate))
            return 0;
        else
            return 1;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public TaskDateInfo getDateInfo() {
        return dateInfo;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public void displayTaskRow() {}

}
