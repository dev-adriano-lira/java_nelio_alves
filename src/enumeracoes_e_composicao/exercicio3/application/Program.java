package enumeracoes_e_composicao.exercicio3.application;

import enumeracoes_e_composicao.exercicio3.entities.Client;
import enumeracoes_e_composicao.exercicio3.entities.Order;
import enumeracoes_e_composicao.exercicio3.entities.OrderItem;
import enumeracoes_e_composicao.exercicio3.entities.Product;
import enumeracoes_e_composicao.exercicio3.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter cliente data:");
        System.out.print("Name: ");
        String nameClient = sc.nextLine();
        System.out.print("Email: ");
        String emailClient = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY)");
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(nameClient, emailClient, birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), status, client);

        System.out.print("How many items to this order? ");
        int qtdItems= sc.nextInt();
        for (int i = 1; i <= qtdItems; i++) {
            sc.nextLine();
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            String nameProduct = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();

            Product product = new Product(nameProduct ,productPrice);
            System.out.print("Quantity: ");
            Integer quantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantity, productPrice, product);
            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println("ORDER SUMMARY");
        System.out.println(order);

        sc.close();
    }
}