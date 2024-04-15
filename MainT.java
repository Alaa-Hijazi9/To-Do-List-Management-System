package Maintask;

import java.util.Scanner;

public class MainT {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        Scanner input = new Scanner(System.in);
        int choiceNumber;
        do {

            System.out.println("___________Main Menu___________");
            System.out.println("What would you like to do?");
            System.out.println("1. Add a new task");
            System.out.println("2. Remove an existing task");
            System.out.println("3. Edit a task");
            System.out.println("4. Mark a task as completed");
            System.out.println("5. List all tasks");
            System.out.println("6. Sort tasks by date");
            System.out.println("7. Exit");

            System.out.print("Enter your Option: ");
            choiceNumber = input.nextInt();
            input.nextLine();

            switch (choiceNumber) {
                case 1:
                    clearScreen();
                    taskList.addTask();
                    break;
                case 2:
                    clearScreen();
                    taskList.removeTask();
                    break;
                case 3:
                    clearScreen();
                    taskList.editTask();
                    break;
                case 4:
                    clearScreen();
                    taskList.markTaskAsCompleted();
                    break;
                case 5:
                    clearScreen();
                    taskList.listTasks();
                    break;
                case 6:
                    clearScreen();
                    taskList.sortByDate();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    clearScreen();
                    System.out.println("Invalid choice. Please try again.");
            }

        }
        while (choiceNumber != 7);
    }
    public static void clearScreen() {
        for (int i = 0; i < 7; i++) {
            System.out.println();
        }
    }
}