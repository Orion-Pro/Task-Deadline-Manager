public class Task implements Comparable<Task>{

    private int id;
    private final String title;
    private final String description;
    private boolean completed; //not final, because it is changed when completed.
    private final TaskDateInfo dateInfo;

    public Task(String TITLE, String DES, boolean COMP, TaskDateInfo DI) { //ID will be set separately
        this.title = TITLE;
        this.description = DES;
        this.completed = COMP;
        this.dateInfo = DI;
    }

    public int compareTo(Task other) {
        return this.getDateInfo().getDueDate().compareTo(other.getDateInfo().getDueDate());
    }

    public int getId() {
        return id;
    }

    public void setID(int ID) {this.id = ID;}

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

    public void displayTaskRow() {
        System.out.printf("%-5s %-12s %-18s %-12s %-10s %n", getId(), getTitle(), getDescription(), getDateInfo().getDueDate(), isCompleted() ? "Complete" : "Incomplete");
    }

}
