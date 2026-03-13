import java.util.Date;
import java.util.ArrayList;

public class TaskTable {

    private ArrayList<Task> dueTasks = new ArrayList<>();

    //What about an array of size 31, use a const array of month lengths to handle invalid date inputs
    //Place a linked list with all tasks with that bucket's due date
    //Remove tasks marked as complete and write to file (for records)

    private final int[] monthLengths = {
        /*Jan*/ 31, /*Feb*/ 28, /*Mar*/ 31, /*Apr*/ 30, /*May*/ 31, /*Jun*/ 30, /*Jul*/ 31, /*Aug*/ 31, /*Sep*/ 30, /*Oct*/ 31, /*Nov*/ 30, /*Dec*/ 31}
        //Improvement: handle leap years.




    public void addTask(Task task) {
        dueTasks.add(task);
    }

    public void viewOverdueTasks() {
        for (Task t : dueTasks) {
            if (t.getDateInfo().isOverdue())
                System.out.println(t + " - ");
        }
    }

}
