package com.enigma.todo.view;

import com.enigma.todo.controller.TodoManager;
import com.enigma.todo.utils.ScannerUtils;

public class TodoView {
    public static void main(String[] args) {
        TodoManager todo = new TodoManager();
        while (true) {
            menu();
            String choice = ScannerUtils.scanText("Enter your choice");
            switch (choice) {
                case "1":
                    while (true) {
                        todo.addTask();
                        if (ScannerUtils.scanText("add again (any/n)?").equals("n")) {
                            break;
                        }
                        System.out.println();
                    }
                    break;
                case "2":
                    todo.updateTask();
                    break;
                case "3":
                    todo.deleteTask();
                    break;
                case "4":
                    todo.viewTask();
                    break;
                case "5":
                    System.exit(1);
                case null:
                    System.out.println("invalid cannot be null");
                    break;
                default:
                    System.out.println("invalid");
            }
        }
    }

    public static void menu() {
        System.out.println("-".repeat(20));
        System.out.println("To Do Application");
        System.out.println("-".repeat(20));
        System.out.println("1. Add Task");
        System.out.println("2. Update Task");
        System.out.println("3. Delete Task");
        System.out.println("4. View All Tasks");
        System.out.println("5. Exit Application");
        System.out.println("-".repeat(20));
    }

}
