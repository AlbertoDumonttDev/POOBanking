package models;

public class Account {
    private int accountNumber;
    private double balance;
    private Client client;

    public Account(int accountNumber, Client client) {
        this.accountNumber = accountNumber;
        this.client = client;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit made successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance or invalid value.");
        }
    }

    public void transfer(Account destination, double amount) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            destination.deposit(amount);
            System.out.println("Transfer completed successfully.");
        } else {
            System.out.println("Transfer failed.");
        }
    }

    public void showBalance() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Client: " + client.getName());
        System.out.println("Amount: R$" + balance);
    }

    // Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public Client getClient() {
        return client;
    }

    public double getBalance() {
        return balance;
    }
}
