package services;

import models.Account;
import models.Client;

import java.util.ArrayList;
import java.util.List;

public class BankService {
    private List<Account> accounts;

    public BankService() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account added successfully!");
    }

    public Account createAccount(String name, String cpf, int age, int accountNumber) {

        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                return null;
            }
        }

        Client client = new Client(name, cpf, age);
        Account account = new Account(accountNumber, client);

        return account;
    }

    public Account findAccountByNumber(int accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                return acc;
            }
        }

        System.out.println("Account not found.");
        return null;
    }

    public void deposit(int accountNumber, double amount) {
        Account account = findAccountByNumber(accountNumber);
        if (account != null) {
            account.deposit(amount);
        }
    }

    public void withdraw(int accountNumber, double amount) {
        Account account = findAccountByNumber(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        }
    }

    public void transfer(int fromAccount, int toAccount, double amount) {
        Account source = findAccountByNumber(fromAccount);
        Account destination = findAccountByNumber(toAccount);
        if (source != null && destination != null) {
            source.transfer(destination, amount);
        }
    }

    public void ShowAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No account registered.");
        } else {
            for (Account acc : accounts) {
                acc.showBalance();
                System.out.println("-------------------------");
            }
        }
    }

    public boolean isCpfAlreadyRegistered(String cpf) {
        for (Account account : accounts) {
            if (account.getClient().getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }
}
