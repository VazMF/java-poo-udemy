package aula125.application;

import aula125.entities.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Account account = new Account(1001, "Alex", 0.0);
        BusinessAccount businessAccount = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        // Upcasting

        Account account1 = businessAccount;
        Account account2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
        Account account3 = new SavingsAccount(1004, "Ana", 0.0, 0.01);

        // Downcasting

        BusinessAccount account4 = (BusinessAccount)account2;
        account4.loan(100.0);

        // BusinessAccount account5 = (BusinessAccount)account3;

        if (account3 instanceof BusinessAccount) {
            BusinessAccount account5 = (BusinessAccount)account3;
            account5.loan(200.0);
            System.out.println("Loan!");
        }

        if (account3 instanceof SavingsAccount) {
            SavingsAccount account5 = (SavingsAccount)account3;
            account5.updateBalance();
            System.out.println("Update!");
        }

        // Sobreposição

        Account account5 = new BusinessAccount(1005, "Bob", 1000.0, 500.0);
        account5.withdraw(200.0);
        System.out.println(account5.getBalance());

        input.close();
    }
}
