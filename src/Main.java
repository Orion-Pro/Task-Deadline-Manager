import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {

    public static void main() {

        TaskManager taskManager = new TaskManager();
        Scanner stringScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);

        byte choice = 10;

        while (choice != 0) {
            System.out.println("\n");
            System.out.println("1. Add a task.");
            System.out.println("2. View all tasks.");
            System.out.println("3. Mark task as completed.");
            System.out.println("4. Remove completed tasks.");
            System.out.println("5. Save tasks to file.");
            System.out.println("6. Load tasks from file.");
            System.out.println("7. View overdue tasks.");
            System.out.print("\nPlease enter an option: ");
            choice = intScanner.nextByte();

            switch (choice) {
                case 1: {
                    System.out.print("Enter task details: ");
                    System.out.print("\nTask ID: ");
                    int taskID = intScanner.nextInt();
                    //scanner.reset();

                    System.out.print("Task Title: ");
                    String taskTitle = stringScanner.nextLine();

                    System.out.print("Task Description: ");
                    String taskDes = stringScanner.nextLine();

                    System.out.print("Due Date (YYYY-MM-DD): ");
                    String dueDate = stringScanner.nextLine();
                    String[] dueDateArray = dueDate.split("-");
                    int[] intDueDateArray = new int[3];
                    for (int i = 0; i < 3; i++) { //surely there's a better way to do this.
                        int number = Integer.parseInt(dueDateArray[i]);
                        intDueDateArray[i] = number;
                    }

                    TaskDateInfo dateInfo = new TaskDateInfo(LocalDateTime.now(), LocalDate.of(intDueDateArray[0], intDueDateArray[1], intDueDateArray[2]));

                    Task newTask = new Task(taskID, taskTitle, taskDes, false, dateInfo);
                    taskManager.addTask(newTask);
                    break;
                }
                case 2: {
                    taskManager.displayTasks();
                    break;
                }
                case 3: {
                    System.out.print("Enter a task ID to search for: ");
                    int searchID = intScanner.nextInt();
                    Task Complete = taskManager.searchByID(searchID);
                    Complete.markCompleted();
                    break;
                }
                case 4: {
                    taskManager.removeCompletedTasks();
                    break;
                }
                case 5: {
                    taskManager.saveToFile();
                    break;
                }
                case 6: {
                    taskManager.loadFromFile();
                    break;
                }
                case 7: {
                    break;
                }
                case 0: {
                    return;
                }
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