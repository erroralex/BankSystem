package com.alexander;

//58. Implementera en klass BankSystem som hanterar flera konton och överföringar mellan dem.
public class BankSystem {

    private double balance;
    private String accountName;
    private Operations operations;
    private double interest;

    public BankSystem() {

    }

    public BankSystem(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    public BankSystem(String accountName, double balance, double interest) {
        this.accountName = accountName;
        this.balance = balance;
        this.interest = interest;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountName() {
        this.accountName = accountName;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance() {
        this.balance = balance;
    }

    public Operations getOperations() {
        return operations;
    }

    public void setOperations(Operations operations) {
        this.operations = operations;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest() {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return ": " + balance + ":-";
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }
}
