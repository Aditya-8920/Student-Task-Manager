import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Daily Task Manager");
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        manager.loadFromFile();

        System.out.println("===== STUDENT TASK MANAGER =====");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Complete");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            
            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Enter number only.");
                sc.nextLine();
                continue;
            }

            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String task = sc.nextLine();
                    manager.addTask(task);
                    break;

                case 2:
                    manager.viewTasks();
                    break;

                case 3:
                    System.out.print("Enter task index: ");
                    int index1 = sc.nextInt();
                    manager.markComplete(index1);
                    break;

                case 4:
                    System.out.print("Enter task index: ");
                    int index2 = sc.nextInt();
                    manager.deleteTask(index2);
                    break;

                case 5:
                    manager.saveToFile();
                    System.out.println("Data saved. Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
