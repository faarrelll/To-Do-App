package com.enigma.todo.utils;
import java.util.Scanner;

public class ScannerUtils {
    static Scanner scanner = new Scanner(System.in);
    public static String scanText(String text){
        while (true){
            System.out.print(text + " : ");
            String input = scanner.nextLine();
            if (input == null || input.isEmpty() || input.isBlank()) {
                System.out.println(text + " cannot be null");
                System.out.println("Please input true or false!");
            } else {
                return input;
            }
        }
    }

    public static boolean scanBollean(String text) {
        while (true){
            System.out.print(text + " : ");
            String input = scanner.nextLine().toLowerCase();
            if (input.isEmpty() || input.isBlank()){
                System.out.println(text+" cannot be empty");
                System.out.println("Invalid input, please input true or false!");
            }
            if (input.equals("true") || input.equals("false")){
                return Boolean.parseBoolean(input);
            }
        }
    }
}
