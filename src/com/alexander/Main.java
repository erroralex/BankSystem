package com.alexander;

import java.util.InputMismatchException;
import java.util.Scanner;

//58. Implementera en klass BankSystem som hanterar flera konton och överföringar mellan dem.
public class Main {

    static boolean isRunning = true;
    static Scanner scanner = new Scanner(System.in);
    static java.util.List<BankSystem> accountList = new java.util.ArrayList<>();

    public static void main(String[] args) {

        accountList.add(new BankSystem("Savings", 1_00_000));
        accountList.add(new BankSystem("Private", 10_000));
        accountList.add(new BankSystem("Household", 1_000));

        while (isRunning) {
            Menu.displayMenu();
            try {
                Menu.menuChoice = scanner.nextInt();
                scanner.nextLine();
                Menu.whatToDo();

            } catch (InputMismatchException ex) {
                System.out.println("Invalid input choice! Press [ENTER] to try again.");
                scanner.nextLine();
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
