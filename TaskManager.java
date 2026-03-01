import java.io.*;
import java.util.*;

public class TaskManager {
    private PriorityQueue<Task> taskQueue;

    public TaskManager() {
        taskQueue = new PriorityQueue<>();
    }

    public void addTask(Task task) {
        taskQueue.add(task);
    }

    public void removeTask() {
        Task removed = taskQueue.poll();
        if (removed != null)
            System.out.println("Removed: " + removed);
        else
            System.out.println("No tasks available.");
    }

    public void viewTasks() {
        if (taskQueue.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (Task task : taskQueue) {
            System.out.println(task);
        }
    }

    public void saveToFile() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("tasks.dat"));
        oos.writeObject(taskQueue);
        oos.close();
    }

    public void loadFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("tasks.dat"));
        taskQueue = (PriorityQueue<Task>) ois.readObject();
        ois.close();
    }
}