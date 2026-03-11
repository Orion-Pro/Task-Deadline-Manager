public class Task {

    private int id;
    private String title;
    private String description;
    private boolean completed;
    TaskDateInfo dateInfo;

    public Task(int ID, String TITLE, String DES, boolean COMP, TaskDateInfo DI) {
        this.id = ID;
        this.title = TITLE;
        this.description = DES;
        this.completed = COMP;
        this.dateInfo = DI;
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
