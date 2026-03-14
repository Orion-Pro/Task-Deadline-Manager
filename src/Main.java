import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.LocalDate;

void main() {

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
        System.out.println("0. Terminate the program.");
        System.out.print("\nPlease enter an option: ");
        choice = intScanner.nextByte();

        switch (choice) { //Improvement: Add Try, catch blocks to handle exceptions.
            case 1: {
                System.out.print("Enter task details: ");
                System.out.print("\nTask ID: ");
                int taskID = intScanner.nextInt();

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

                Task newTask = new Task(taskTitle, taskDes, false, dateInfo);
                newTask.setID(taskID);
                taskManager.taskTable.addTask(newTask);
                break;
            }
            case 2: {
                taskManager.displayTasks();
                break;
            }
            case 3: {
                System.out.print("Enter a task ID to search for: ");
                try {
                    int searchID = intScanner.nextInt();
                    Task complete = taskManager.searchByID(searchID);
                    if (complete.isCompleted()) {
                        System.out.println("Task is already complete.");
                        break;
                    }
                    if (complete == null)
                        throw new Exception(); //Error message already printed in TaskManager
                    complete.markCompleted();
                    System.out.println("Task successfully marked as completed.");
                }
                catch (Exception e) {
                    System.out.println(TaskManager.Error_Message);
                }
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
                //taskManager.taskTable.viewOverdueTasks();
                break;
            }
            case 0: {
                return;
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




//Important note, O(n) algorithms are unavoidable. Print all tasks has to be O(n)
//ID serves to differentiate tasks with the same title (mostly)
//We search by ID only for req3
//We more often than not search by date (overdue or not)
