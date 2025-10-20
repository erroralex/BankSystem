package com.alexander;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

import static com.alexander.Main.accountList;
import static com.alexander.Main.scanner;

public class Operations {
    //──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    //Method to clear the console
    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    //──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    //Method to make deposits
    public void deposit(Scanner scanner, List<BankSystem> accountList) {
        clearScreen();
        if (accountList.isEmpty()) {
            PrintColor.red("No accounts to deposit into.[ENTER] to continue: ");
            return;
        }

        PrintColor.cyan(Menu.textBlocks());
        System.out.println("\nList of all accounts:");
        for (int i = 0; i < accountList.size(); i++) {
            PrintColor.green((i + 1) + ": " + accountList.get(i).getAccountName() + " - Balance: " + accountList.get(i).getBalance() + ":-");
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
                        PrintColor.red("Invalid deposit amount. Please enter a positive number.");
                    }
                } catch (InputMismatchException e) {
                    PrintColor.red("Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                }
            }
            accountList.get(index).deposit(amount);
            PrintColor.green("\nDeposited " + amount + ":- to " + accountList.get(index).getAccountName() + " account. " + "New Balance: " + accountList.get(index).getBalance() + ":-");

            System.out.print("\nPress [ENTER] to return to the menu...");
            scanner.nextLine();
        } else {
            PrintColor.red("Invalid account number.");
        }
    }

    //──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    //Method to make withdrawals
    public void withdraw(Scanner scanner, List<BankSystem> accountList) {
        clearScreen();
        if (accountList.isEmpty()) {
            PrintColor.red("No accounts to withdraw from.");
            return;
        }

        PrintColor.cyan(Menu.textBlocks());
        System.out.println("\nList of all accounts:");
        for (int i = 0; i < accountList.size(); i++) {
            PrintColor.green((i + 1) + ": " + accountList.get(i).getAccountName() + " - Balance: " + accountList.get(i).getBalance() + ":-");
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
                        PrintColor.red("Invalid withdrawal amount. Please enter a positive number " + "less than or equal to the balance of the source account.");
                    }
                } catch (InputMismatchException e) {
                    PrintColor.red("Invalid input. Please enter a valid number.");
                    scanner.nextLine();
                }
            }
            accountList.get(index).withdraw(amount);
            PrintColor.green("Withdrew " + amount + ":- from " + accountList.get(index).getAccountName() + " account. New Balance: " + accountList.get(index).getBalance() + ":-");

            System.out.print("\nPress [ENTER] to return to the menu...");
            scanner.nextLine();

        } else {
            PrintColor.red("Invalid account number.");
        }
    }

    //──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    //Method to transfer between accounts
    public void transfer(Scanner scanner, List<BankSystem> accountList) {
        clearScreen();
        if (accountList.isEmpty()) {
            PrintColor.red("No accounts to transfer from.");
            return;
        }

        PrintColor.cyan(Menu.textBlocks());
        System.out.println("\nList of all accounts:");
        for (int i = 0; i < accountList.size(); i++) {
            PrintColor.green((i + 1) + ": " + accountList.get(i).getAccountName() + " - Balance: " + accountList.get(i).getBalance() + ":-");
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
                    PrintColor.cyan((i + 1) + ": " + accountList.get(i).getAccountName() + " - Balance: " + accountList.get(i).getBalance() + ":-");
                }
                System.out.print("Enter the number of the account to transfer to: ");
                int indexTo = scanner.nextInt() - 1;
                scanner.nextLine();

                if (indexTo >= 0 && indexTo < accountList.size()) {
                    accountList.get(indexFrom).withdraw(amount);
                    accountList.get(indexTo).deposit(amount);
                    PrintColor.green("\nTransferred " + amount + ":- from " + accountList.get(indexFrom).getAccountName() + " to " + accountList.get(indexTo).getAccountName());
                } else {
                    PrintColor.red("Invalid target account number.");
                }
            } else {
                PrintColor.red("Invalid transfer amount. Please enter a positive number " + "less than or equal to the balance of the source account.");
            }
        } else {
            PrintColor.red("Invalid source account number.");
        }

        System.out.print("\nPress [ENTER] to return to the menu...");
    }

    //──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    //Method to list all accounts
    public void listAll(Scanner scanner, List<BankSystem> accountList) {
        clearScreen();
        if (accountList.isEmpty()) {
            PrintColor.red("No accounts to display.");
        } else {
            PrintColor.cyan(Menu.textBlocks());
            System.out.println("\nList of all accounts:");
            for (BankSystem account : Main.accountList) {
                PrintColor.green(account.getAccountName() + account.toString());
            }
        }
        System.out.print("\nPress [ENTER] to return to the menu...");
    }

    //──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    //Method to create new account
    public void openAccount(Scanner scanner, List<BankSystem> accountList) {
        clearScreen();
        PrintColor.cyan(Menu.textBlocks());
        System.out.println("\nOpen a new bank account:");
        System.out.print("Enter account name: ");
        String accountName = scanner.nextLine();

        if (accountName.isEmpty()) {
            PrintColor.red("Account name cannot be empty.");
            return;
        }

        // Check if the account already exists
        for (BankSystem account : accountList) {
            if (account.getAccountName().equalsIgnoreCase(accountName)) {
                PrintColor.red("Account with this name already exists.");
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
                    PrintColor.red("Initial deposit must be a positive number.");
                }
            } catch (InputMismatchException e) {
                PrintColor.red("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the buffer
            }
        }

        //Set interest rate
        double interest = 0;
        while (interest <= 0) {
            try {
                System.out.println("Enter interest rate (0.03 = 3%)");
                interest = scanner.nextDouble() * 100;
                scanner.nextLine();

                if (interest < 0) {
                    PrintColor.red("Interest must be a positive number.");
                }
            } catch (InputMismatchException e) {
                PrintColor.red("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the buffer
            }
        }

        accountList.add(new BankSystem(accountName, balance, interest));
        PrintColor.green("\nNew account created: " + accountName + " - Balance: " + balance + ":-, interest rate: " + interest + "%");

        System.out.print("\nPress [ENTER] to return to the menu...");
    }

    //──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    //Method to close and existing account
    public void closeAccount(Scanner scanner, List<BankSystem> accountList) {

        if (accountList.isEmpty()) {
            PrintColor.red("No accounts to delete.");
            return;
        }

        PrintColor.cyan(Menu.textBlocks());
        System.out.println("\nClose an existing bank account:");

        for (int i = 0; i < accountList.size(); i++) {
            System.out.println((i + 1) + ": " + accountList.get(i).getAccountName() + " - Balance: " + accountList.get(i).getBalance() + ":-");
        }

        System.out.print("Enter the number of the account to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        PrintColor.red("Do you want to proceed with an deleting account? (yes/no)");
        String response = scanner.next().trim().toLowerCase();

        if (index >= 0 && index < accountList.size() && "yes".equals(response)) {
            BankSystem accountToDelete = accountList.remove(index);
            System.out.println("\nDeleted account: " + accountToDelete.getAccountName());
        } else {
            PrintColor.red("Invalid input.");
        }

        System.out.print("\nPress [ENTER] to return to the menu...");
        scanner.nextLine();
    }

    public void interestRate(Scanner scanner, List<BankSystem> accountList) {
        clearScreen();
        if (accountList.isEmpty()) {
            PrintColor.red("No accounts to transfer from.");
            return;
        }

        PrintColor.cyan(Menu.textBlocks());
        System.out.println("\nList of all accounts:");
        for (int i = 0; i < accountList.size(); i++) {
            PrintColor.green((i + 1) + ": " + accountList.get(i).getAccountName() + " - Balance: " + accountList.get(i).getBalance() + ":-");
        }

        System.out.print("Enter the number of the account to see it's interest-rate: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        accountList.get(index);
        PrintColor.green(accountList.get(index).getAccountName() + " accounts interest rate is: " + accountList.get(index).getInterest() * 100 + "%");

        double interestYear = accountList.get(index).getBalance() * accountList.get(index).getInterest();

        System.out.println("This will result in " + interestYear + ":- in earnings over a year with the current balance");

        System.out.print("\nPress [ENTER] to return to the menu...");
    }
}



