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
        PrintColor.cyan(textBlocks());
        System.out.println("\nWelcome to the Banking System!");
        System.out.println("What would you like to do today?");
        System.out.println("---------------------------------------");
        PrintColor.cyan("[1] - List my accounts");
        PrintColor.cyan("[2] - Make deposit");
        PrintColor.cyan("[3] - Make withdraw");
        PrintColor.cyan("[4] - Transfer between accounts");
        System.out.println("---------------------------------------");
        PrintColor.cyan("[5] - Open new account");
        PrintColor.cyan("[6] - Close existing account");
        System.out.println("---------------------------------------");
        PrintColor.red("[0] - Exit program");
        System.out.print("\nEnter the corresponding number and press [ENTER]:");
    }

    public static void whatToDo() {

        switch (menuChoice) {

            case 1:
                Operations listAll = new Operations();
                listAll.listAll(scanner, accountList);
                break;

            case 2:
                Operations deposit = new Operations();
                deposit.deposit(scanner, accountList);
                break;

            case 3:
                Operations withdraw = new Operations();
                withdraw.withdraw(scanner, accountList);
                break;

            case 4:
                Operations transfer = new Operations();
                transfer.transfer(scanner, accountList);
                break;

            case 5:
                Operations openAccount = new Operations();
                openAccount.openAccount(scanner, accountList);
                break;

            case 6:
                Operations closeAccount = new Operations();
                closeAccount.closeAccount(scanner, accountList);
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
