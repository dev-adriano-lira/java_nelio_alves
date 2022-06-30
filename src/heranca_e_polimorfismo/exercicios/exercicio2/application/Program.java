package heranca_e_polimorfismo.exercicios.exercicio2.application;

import heranca_e_polimorfismo.exercicios.exercicio2.entities.Product;
import heranca_e_polimorfismo.exercicios.exercicio2.entities.ImportedProduct;
import heranca_e_polimorfismo.exercicios.exercicio2.entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            if (ch == 'c') {
                Product prod = new Product(name, price);
                list.add(prod);
            }
            else if (ch == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date date = sdf.parse(sc.next());
                Product product = new UsedProduct(name, price, date);
                list.add(product);
            }
            else {
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                Product prod = new ImportedProduct(name, price, customsFee);
                list.add(prod);
            }
        }

        System.out.println();
        System.out.println("PRINCE TAGS:");
        for (Product p : list) {
            System.out.println(p.priceTag());
        }



    }
}
