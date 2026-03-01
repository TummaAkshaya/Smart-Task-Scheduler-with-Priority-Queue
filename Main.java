import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Remove Highest Priority Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Save Tasks");
            System.out.println("5. Load Tasks");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter priority (1-High, 2-Medium, 3-Low): ");
                    int priority = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter deadline: ");
                    String deadline = sc.nextLine();

                    manager.addTask(new Task(title, priority, deadline));
                    break;

                case 2:
                    manager.removeTask();
                    break;

                case 3:
                    manager.viewTasks();
                    break;

                case 4:
                    manager.saveToFile();
                    System.out.println("Tasks saved.");
                    break;

                case 5:
                    manager.loadFromFile();
                    System.out.println("Tasks loaded.");
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}