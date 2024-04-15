package Maintask;
import java.util.Scanner;
public class TaskList {
    private Task[] tasks;
    private int count;
    private Scanner scanner;
    public TaskList() {
        tasks = new Task[5];
        count = 0;
        scanner = new Scanner(System.in);
    }
    /
     * {@link #addTask()#checkIdUniqueness()#removeTask()#editTask()#markTaskAsCompleted()#listTasks()#sortByDate()#swapTasks()}
     /
    public void addTask() {
        if (count == tasks.length) {
            System.out.println("Task list is full. Cannot add more tasks.");
            return;
        }
        Task task = new Task();

        boolean validId = false;
        int id = 0;

        while (!validId) {
            System.out.print("Enter task id: ");
            id = scanner.nextInt();
            scanner.nextLine();

            if (id <= 0) {
                System.out.println("Invalid ID. Please enter a positive value.");
            } else if (!checkIdUniqueness(id)) {
                System.out.println("Task with ID " + id + " already exists. Please enter a unique ID.");
            } else {
                validId = true;
            }
        }
        task.setId(id);

        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        task.setDescripotion(description);

        Date dueDate = new Date();

        boolean validDay = false;
        int day = 0;

        while (!validDay) {
            System.out.print("Enter task day: ");
            day = scanner.nextInt();
            if (day >= 1 && day <= 31) {
                validDay = true;
            } else {
                System.out.println("Invalid day. Please enter a value between 1 and 31.");
            }
        }

        dueDate.setDay(day);

        boolean validMonth = false;
        int month = 0;

        while (!validMonth) {
            System.out.print("Enter task month: ");
            month = scanner.nextInt();
            if (month >= 1 && month <= 12) {
                validMonth = true;
            } else {
                System.out.println("Invalid month. Please enter a value between 1 and 12.");
            }
        }

        dueDate.setMonth(month);

        boolean validYear = false;
        int year = 0;

        while (!validYear) {
            System.out.print("Enter task year: ");
            year = scanner.nextInt();
            if (year >= 2023) {
                validYear = true;
            } else {
                System.out.println("Invalid year. Please enter a value equal to or greater than 2023.");
            }
        }

        dueDate.setYear(year);
        scanner.nextLine();

        task.setDueDate(dueDate);

        tasks[count] = task;
        count++;

        System.out.println("\nTask added successfully.\n");
    }

    private boolean checkIdUniqueness(int id) {
        for (int i = 0; i < count; i++) {
            if (tasks[i].getId() == id) {
                return false;
            }
        }
        return true;
    }

    public void removeTask() {
        if (count == 0) {
            System.out.println("Task list is empty. Cannot remove any tasks.");
            return;
        }

        int taskId = 0;
        boolean validId = false;

        while (!validId) {
            System.out.print("Enter the ID of the task to delete: ");
            taskId = scanner.nextInt();
            scanner.nextLine();

            if (taskId <= 0) {
                System.out.println("Invalid ID. Please enter a positive value.");
            } else {
                validId = true;
            }
        }

        int foundIndex = -1;
        for (int i = 0; i < count; i++) {
            if (tasks[i].getId() == taskId) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            for (int i = foundIndex; i < count - 1; i++) {
                tasks[i] = tasks[i + 1];
            }
            tasks[count - 1] = null;

            for (int i = 0; i < count; i++) {
                tasks[i].setId(i + 1);
            }
            System.out.println("Task with ID " + taskId + " deleted successfully.");
        } else {
            System.out.println("Task with ID " + taskId + " not found.");
        }
    }

    public void editTask() {
        int taskId = 0;
        boolean validId = false;

        while (!validId) {
            System.out.print("Enter the ID of the task to edit: ");
            taskId = scanner.nextInt();
            scanner.nextLine();

            if (taskId <= 0) {
                System.out.println("Invalid ID. Please enter a positive value.");
            } else {
                validId = true;
            }
        }

        int foundIndex = -1;
        for (int i = 0; i < count; i++) {
            if (tasks[i].getId() == taskId) {
                foundIndex = i;

                System.out.print("Enter new task description: ");
                String newDescription = scanner.nextLine();
                tasks[i].setDescripotion(newDescription);

                Date dueDate = tasks[i].getDueDate();

                boolean validDay = false;
                int newDay = 0;

                while (!validDay) {
                    System.out.print("Enter new task day: ");
                    newDay = scanner.nextInt();
                    if (newDay >= 1 && newDay <= 31) {
                        validDay = true;
                    } else {
                        System.out.println("Invalid day. Please enter a value between 1 and 31.");
                    }
                }

                dueDate.setDay(newDay);

                boolean validMonth = false;
                int newMonth = 0;

                while (!validMonth) {
                    System.out.print("Enter new task month: ");
                    newMonth = scanner.nextInt();
                    if (newMonth >= 1 && newMonth <= 12) {
                        validMonth = true;
                    } else {
                        System.out.println("Invalid month. Please enter a value between 1 and 12.");
                    }
                }

                dueDate.setMonth(newMonth);

                boolean validYear = false;
                int newYear = 0;

                while (!validYear) {
                    System.out.print("Enter new task year: ");
                    newYear = scanner.nextInt();
                    if (newYear >= 2023) {
                        validYear = true;
                    } else {
                        System.out.println("Invalid year. Please enter a value equal to or greater than 2023.");
                    }
                }

                dueDate.setYear(newYear);
                scanner.nextLine();

                System.out.println("Task edited successfully.\n");
                return;
            }
        }

        if (foundIndex == -1) {
            System.out.println("Task with ID " + taskId + " not found.\n");
        }
    }

    public void markTaskAsCompleted() {
        int taskId = 0;
        boolean validId = false;
        while (!validId) {
            System.out.print("Enter the ID of the task to mark as completed: ");
            taskId = scanner.nextInt();
            scanner.nextLine();

            if (taskId <= 0) {
                System.out.println("Invalid ID. Please enter a positive value.");
            } else {
                validId = true;
            }
        }
        int foundIndex = -1;
        for (int i = 0; i < count; i++) {
            if (tasks[i].getId() == taskId) {
                foundIndex = i;
                tasks[i].setIscompleted(true);
                System.out.println("Task marked as completed.\n");
                break;
            }
        }
    }

    public void listTasks() {
        System.out.println("Tasks in the list:");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Task" + "\t\t" + "Description" + "\t\t\t\t" + "Due Date" + "\t\t\t" + "Status");
        System.out.println("---------------------------------------------------------------------");
        for (int i = 0; i < count; i++) {
            Task task = tasks[i];
            String status = task.isIscompleted() ? "Completed" : "In progress";
            System.out.println(i + 1 + "\t\t\t" + task.getDescripotion() + "\t\t\t\t\t" + task.getDueDate().getDay() + "\\" + task.getDueDate().getMonth() + "\\" + task.getDueDate().getYear() + "\t\t\t" + status);
            System.out.println("---------------------------------------------------------------------");

        }
    }

    public void sortByDate() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                Date date1 = tasks[i].getDueDate();
                Date date2 = tasks[j].getDueDate();

                if (date1.getYear() > date2.getYear()) {
                    swapTasks(i, j);
                } else if (date1.getYear() == date2.getYear() && date1.getMonth() > date2.getMonth()) {
                    swapTasks(i, j);
                } else if (date1.getYear() == date2.getYear() && date1.getMonth() == date2.getMonth() && date1.getDay() > date2.getDay()) {
                    swapTasks(i, j);
                }
            }
        }

        System.out.println("Tasks sorted by date in ascending order.");
    }

    private void swapTasks(int index1, int index2) {
        Task temp = tasks[index1];
        tasks[index1] = tasks[index2];
        tasks[index2] = temp;
    }

}