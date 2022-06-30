package classes_abstratas.metodos_abstratos.exercicio.application;

import classes_abstratas.metodos_abstratos.exercicio.entities.Company;
import classes_abstratas.metodos_abstratos.exercicio.entities.Individual;
import classes_abstratas.metodos_abstratos.exercicio.entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();


        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();
            if (ch == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                list.add(new Individual(name, anualIncome, healthExpenditures));
            } else {
                System.out.print("Number of employees: ");
                int numberEmployees = sc.nextInt();
                list.add(new Company(name, anualIncome, numberEmployees));
            }
        }

        double sum = 0;
        System.out.println();
        System.out.println("TAXES PAID:");
        for (TaxPayer t : list) {
            double tax = t.tax();
            System.out.println(t.getName() + ": $ " + String.format("%.2f", tax));
            sum += tax;
        }
        System.out.println();
        System.out.println("TOTAL TAXES: " + String.format("%.2f", sum));
    }

}
