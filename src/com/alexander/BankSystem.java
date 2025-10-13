package com.alexander;

//58. Implementera en klass BankSystem som hanterar flera konton och överföringar mellan dem.
public class BankSystem {

    private double balance;
    private String accountName;

    public BankSystem() {

    }

    public BankSystem(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
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
