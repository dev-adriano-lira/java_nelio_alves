package excecoes.exercicio2.application;

import excecoes.exercicio1.model.exceptions.DomainException;
import excecoes.exercicio2.model.entities.Account;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws DomainException {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            sc.nextLine();
            System.out.print("Holder: ");
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            double initialBalance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdraw = sc.nextDouble();

            Account account = new Account(number, holder, initialBalance, withdraw);

            System.out.print("Enter amoutn for withdraw: ");
            double amount = sc.nextDouble();
            account.withdraw(amount);
            System.out.print("New balance: " + account.getBalance());

        } catch (DomainException e) {
            System.out.println(e.getMessage());
        }





    }
}
