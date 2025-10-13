package com.alexander;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;


public class Operations {
    //──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    //Metod för att rensa konsollen
    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    //──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    //Metod för att göra insättning
    public static void deposit(Scanner scanner, List<BankSystem> accountList) {
        clearScreen();
        if (accountList.isEmpty()) {
            System.out.println("No accounts to deposit into.");
            return;
        }

        System.out.println(Menu.textBlocks());
        System.out.println("\nList of all accounts:");
        for (int i = 0; i < accountList.size(); i++) {
            System.out.println((i + 1) + ": " + accountList.get(i).getAccountName() + " - Balance: " + accountList.get(i).getBalance() + ":-");
        }

        System.out.print("Enter the number of the account to deposit into: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < accountList.size()) {
            double amount;

            while (true) {
                try {
                    System.out.print("Enter the amount to deposit: ");
                    amount = scanner.nextDouble();
                    if (amount > 0) {
                        break;
                    } else {
                        System.out.println("Invalid deposit amount. Please enter a positive number.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                }
            }
            accountList.get(index).deposit(amount);
            System.out.println("\nDeposited " + amount + ":- to " + accountList.get(index).getAccountName() + " account. New Balance: " + accountList.get(index).getBalance() + ":-");

            System.out.print("\nPress [ENTER] to return to the menu...");
            scanner.nextLine();
        } else {
            System.out.println("Invalid account number.");
        }
    }

    //──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    //Metod för att göra uttag
    public static void withdraw(Scanner scanner, List<BankSystem> accountList) {
        clearScreen();
        if (accountList.isEmpty()) {
            System.out.println("No accounts to withdraw from.");
            return;
        }

        System.out.println(Menu.textBlocks());
        System.out.println("\nList of all accounts:");
        for (int i = 0; i < accountList.size(); i++) {
            System.out.println((i + 1) + ": " + accountList.get(i).getAccountName() + " - Balance: " + accountList.get(i).getBalance() + ":-");
        }

        System.out.print("Enter the number of the account to withdraw from: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < accountList.size()) {
            double amount;

            while (true) {
                try {
                    System.out.print("Enter the amount to withdraw: ");
                    amount = scanner.nextDouble();

                    if (amount > 0 && amount <= accountList.get(index).getBalance()) {
                        break;
                    } else {
                        System.out.println("Invalid withdrawal amount. Please enter a positive number " + "less than or equal to the balance of the source account.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                }
            }
            accountList.get(index).withdraw(amount);
            System.out.println("Withdrawed " + amount + ":- from " + accountList.get(index).getAccountName() + " account. New Balance: " + accountList.get(index).getBalance() + ":-");

            System.out.print("\nPress [ENTER] to return to the menu...");
            scanner.nextLine();

        } else {
            System.out.println("Invalid account number.");
        }
    }

    //──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    //Metod för att överföra mellan konton
    public static void transfer(Scanner scanner, List<BankSystem> accountList) {
        clearScreen();
        if (accountList.isEmpty()) {
            System.out.println("No accounts to transfer from.");
            return;
        }

        System.out.println(Menu.textBlocks());
        System.out.println("\nList of all accounts:");
        for (int i = 0; i < accountList.size(); i++) {
            System.out.println((i + 1) + ": " + accountList.get(i).getAccountName() + " - Balance: " + accountList.get(i).getBalance() + ":-");
        }

        System.out.print("Enter the number of the account to transfer from: ");
        int indexFrom = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indexFrom >= 0 && indexFrom < accountList.size()) {
            double amount;
            System.out.print("Enter the amount to transfer: ");
            amount = scanner.nextDouble();

            if (amount > 0 && amount <= accountList.get(indexFrom).getBalance()) {
                System.out.println("\nList of all accounts:");
                for (int i = 0; i < accountList.size(); i++) {
                    System.out.println((i + 1) + ": " + accountList.get(i).getAccountName() + " - Balance: " + accountList.get(i).getBalance() + ":-");
                }
                System.out.print("Enter the number of the account to transfer to: ");
                int indexTo = scanner.nextInt() - 1;
                scanner.nextLine();

                if (indexTo >= 0 && indexTo < accountList.size()) {
                    accountList.get(indexFrom).withdraw(amount);
                    accountList.get(indexTo).deposit(amount);
                    System.out.println("\nTransferred " + amount + ":- from " + accountList.get(indexFrom).getAccountName() + " to " + accountList.get(indexTo).getAccountName());
                } else {
                    System.out.println("Invalid target account number.");
                }
            } else {
                System.out.println("Invalid transfer amount. Please enter a positive number " + "less than or equal to the balance of the source account.");
            }
        } else {
            System.out.println("Invalid source account number.");
        }

        System.out.print("\nPress [ENTER] to return to the menu...");
        //scanner.nextLine();
    }

    //──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    //Metod för att lista alla konton
    public static void listAll(Scanner scanner, List<BankSystem> accountList) {
        clearScreen();
        if (accountList.isEmpty()) {
            System.out.println("No accounts to display.");
        } else {
            System.out.println(Menu.textBlocks());
            System.out.println("\nList of all accounts:");
            for (BankSystem account : Main.accountList) {
                System.out.println(account.getAccountName() + account.toString());
            }
        }
        System.out.print("\nPress [ENTER] to return to the menu...");
        //scanner.nextLine();
    }

    //──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public static void openAccount(Scanner scanner, List<BankSystem> accountList) {
        clearScreen();
        System.out.println(Menu.textBlocks());
        System.out.println("\nOpen a new bank account:");
        System.out.print("Enter account name: ");
        String accountName = scanner.nextLine();

        if (accountName.isEmpty()) {
            System.out.println("Account name cannot be empty.");
            return;
        }

        // Check if the account already exists
        for (BankSystem account : accountList) {
            if (account.getAccountName().equalsIgnoreCase(accountName)) {
                System.out.println("Account with this name already exists.");
                return;
            }
        }

        // Ask for initial deposit amount
        double balance = 0;
        while (balance <= 0) {
            try {
                System.out.print("Enter the initial deposit amount: ");
                balance = scanner.nextDouble();
                scanner.nextLine();

                if (balance < 0) {
                    System.out.println("Initial deposit must be a positive number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the buffer
            }
        }

        accountList.add(new BankSystem(accountName, balance));
        System.out.println("\nNew account created: " + accountName + " - Balance: " + balance + ":-");

        System.out.print("\nPress [ENTER] to return to the menu...");
        //scanner.nextLine();
    }

    //──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public static void closeAccount(Scanner scanner, List<BankSystem> accountList) {
        //clearScreen();
        if (accountList.isEmpty()) {
            System.out.println("No accounts to delete.");
            return;
        }

        System.out.println(Menu.textBlocks());
        System.out.println("\nClose an existing bank account:");

        for (int i = 0; i < accountList.size(); i++) {
            System.out.println((i + 1) + ": " + accountList.get(i).getAccountName() + " - Balance: " + accountList.get(i).getBalance() + ":-");
        }

        System.out.print("Enter the number of the account to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.println("Do you want to proceed with an deleting account? (yes/no)");
        String response = scanner.next().trim().toLowerCase();

        if (index >= 0 && index < accountList.size() && "yes".equals(response)) {
            BankSystem accountToDelete = accountList.remove(index);
            System.out.println("\nDeleted account: " + accountToDelete.getAccountName());
        } else {
            System.out.println("Invalid input.");
        }

        System.out.print("\nPress [ENTER] to return to the menu...");
        scanner.nextLine();
    }
}

