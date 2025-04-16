import services.BankService;
import models.Client;
import models.Account;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankService bankService = new BankService();

        while (true) {
            System.out.println("\n--- BANK SYSTEM ---");
            System.out.println("1. Create new account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Show account details");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Client name: ");
                    String name = scanner.nextLine();

                    System.out.print("Client CPF: ");
                    String cpf = scanner.nextLine();

                    if (bankService.isCpfAlreadyRegistered(cpf)) {
                        System.out.println("CPF is already registered.");
                        break;
                    }

                    System.out.print("Client age: ");
                    int age = scanner.nextInt();

                    System.out.print("Account number: ");
                    int accNumber = scanner.nextInt();

                    Account account = bankService.createAccount(name, cpf, age, accNumber);

                    if (account != null) {
                        bankService.addAccount(account);
                        System.out.println("Account created successfully!");
                    } else {
                        System.out.println("Account creation failed. Please try again.");
                    }
                    break;

                case 2:
                    System.out.print("Account number: ");
                    int depositNumber = scanner.nextInt();
                    System.out.print("Amount to deposit: ");
                    double amount = scanner.nextDouble();

                    bankService.deposit(depositNumber, amount);
                    break;

                case 3:
                    System.out.print("Account number: ");
                    int withdrawNumber = scanner.nextInt();
                    System.out.print("Amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();

                    bankService.withdraw(withdrawNumber, withdrawAmount);
                    break;

                case 4:
                    System.out.print("Source account number: ");
                    int fromAcc = scanner.nextInt();
                    System.out.print("Destination account number: ");
                    int toAcc = scanner.nextInt();
                    System.out.print("Amount to transfer: ");
                    double transferAmount = scanner.nextDouble();

                    bankService.transfer(fromAcc, toAcc, transferAmount);
                    break;

                case 5:
                    System.out.print("Account number: ");
                    int showAcc = scanner.nextInt();
                    Account found = bankService.findAccountByNumber(showAcc);
                    if (found != null) {
                        found.showBalance();
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
