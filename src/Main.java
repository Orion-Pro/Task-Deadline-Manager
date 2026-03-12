import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {

    public static void main() {

        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Add a task.");
        System.out.println("2. View all tasks.");
        System.out.println("3. Mark task as completed.");
        System.out.println("4. Remove completed tasks.");
        System.out.println("5. Save tasks to file.");
        System.out.println("6. Load tasks from file.");
        System.out.println("7. View overdue tasks.");
        System.out.println("\nPlease enter an option: ");

        byte choice = scanner.nextByte();

        switch (choice) {
            case 1: {
                System.out.println("Enter tasks detail: ");
                System.out.println("Task ID: ");
                int taskID = scanner.nextInt();

                System.out.println("Task Title: ");
                String taskTitle = scanner.nextLine();

                System.out.println("Task Description: ");
                String taskDes = scanner.nextLine();

                System.out.println("Due Date (YYYY-MM-DD): ");
                String dueDate = scanner.nextLine();
                String[] dueDateArray = dueDate.split("-");
                int[] intDueDateArray = new int[3];
                for (int i = 0; i < 3; i++) { //surely there's a better way to do this.
                    int number = Integer.parseInt(dueDateArray[i]);
                    intDueDateArray[i] = number;
                }

                TaskDateInfo dateInfo = new TaskDateInfo(LocalDateTime.now(), LocalDate.of(intDueDateArray[0], intDueDateArray[1], intDueDateArray[2]));

                Task newTask = new Task(taskID, taskTitle, taskDes, false, dateInfo);
                taskManager.addTask(newTask);
            }
            case 2: {
                taskManager.displayTasks();
            }
            case 3: {
                System.out.println("Enter a task ID to search for: ");
                int searchID = scanner.nextInt();
                Task Complete = taskManager.searchByID(searchID);
                Complete.markCompleted();
            }
            case 4: {
                taskManager.removeCompletedTasks();
            }
            case 5: {
                taskManager.saveToFile();
            }
            case 6: {
                taskManager.loadFromFile();
            }
            case 7: {

            }
        }

    }

}


//Requirements:
//- Add a task
//- View all tasks
//- Mark a task as completed
//- Remove completed tasks using an iterator
//- Save tasks to file
//- Load tasks from file
//- Show overdue tasks
//- Print all tasks in a formatted table using printf()