package com.alexander;

import java.util.Scanner;

import static com.alexander.Main.accountList;
import static com.alexander.Main.scanner;


public class Menu {

    public static int menuChoice;

    public static String textBlocks() {
        return """                
                 ░       ░░░░      ░░░   ░░░  ░░  ░░░░  ░
                 ▒  ▒▒▒▒  ▒▒  ▒▒▒▒  ▒▒    ▒▒  ▒▒  ▒▒▒  ▒▒
                 ▓       ▓▓▓  ▓▓▓▓  ▓▓  ▓  ▓  ▓▓     ▓▓▓▓
                 █  ████  ██        ██  ██    ██  ███  ██
                 █       ███  ████  ██  ███   ██  ████  █                
                """;
    }

    static void displayMenu() {
        Operations.clearScreen();
        System.out.println(textBlocks());
        System.out.println("\nWelcome to the Banking System!");
        System.out.println("What would you like to do?");
        System.out.println("---------------------------------------");
        System.out.println("[1] - List my accounts");
        System.out.println("[2] - Make deposit");
        System.out.println("[3] - Make withdraw");
        System.out.println("[4] - Transfer between accounts");
        System.out.println("---------------------------------------");
        System.out.println("[5] - Open new account");
        System.out.println("[6] - Close existing account");
        System.out.println("---------------------------------------");
        System.out.println("[0] - Exit program");
        System.out.print("\nEnter the corresponding number and press [ENTER]:");
    }

    public static void whatToDo() {

        switch (menuChoice) {

            case 1:
                Operations.listAll(scanner, accountList);
                break;

            case 2:
                Operations.deposit(scanner, accountList);
                break;

            case 3:
                Operations.withdraw(scanner, accountList);
                break;

            case 4:
                Operations.transfer(scanner, accountList);
                break;

            case 5:
                Operations.openAccount(scanner, accountList);
                break;

            case 6:
                Operations.closeAccount(scanner, accountList);
                break;

            case 0:
                Main.isRunning = false;
                System.out.println("Thanks for using this program!");
                break;

            default:
                System.out.println("You need to input a valid number! Try again. Press [ENTER] ");
                scanner.nextLine();
                break;
        }
        scanner.nextLine();

    }
}
