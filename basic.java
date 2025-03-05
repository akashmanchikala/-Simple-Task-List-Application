import java.util.ArrayList;
import java.util.Scanner;

public class TaskListApp {
    
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    listTasks();
                    break;
                case 4:
                    System.out.println("Exiting the application...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Show the menu to the user
    private static void showMenu() {
        System.out.println("\nTask List Menu:");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. List Tasks");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    // Get user's choice from the menu
    private static int getUserChoice() {
        return scanner.nextInt();
    }

    // Add a new task to the list
    private static void addTask() {
        scanner.nextLine();  // Consume newline left-over
        System.out.print("Enter the task description: ");
        String taskDescription = scanner.nextLine();
        tasks.add(taskDescription);
        System.out.println("Task added: " + taskDescription);
    }

    // Remove a task from the list
    private static void removeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available to remove.");
            return;
        }

        listTasks();
        System.out.print("Enter the task number to remove: ");
        int taskIndex = scanner.nextInt() - 1;  // Convert to 0-based index

        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            String removedTask = tasks.remove(taskIndex);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // List all tasks
    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\nTask List:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}
