package com.coding;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello welcome to my cafe!");
        ArrayList<Product> products = new ArrayList<>();
        Product coffee = new Product("coffee", 3.00);
        products.add(coffee);
        Product latte = new Product("latte", 2.00);
        products.add(latte);
        Product tea = new Product("tea", 4.00);
        products.add(tea);

        printMenu(products);

        Scanner scanner = new Scanner(System.in);


        Map<Product, Integer> bestellung = new HashMap<>();


        while (true) {
            int choice = readUserChoice(scanner, products.size());
            if (choice == 0) {
                break;
            } else {
                Product p = products.get(choice - 1);
                addToCart(bestellung, p);
            }

        }

        double applyDiscount = applyDiscount(printReceipt(bestellung));
        System.out.printf("Endbetrag nach Rabatt : $%.2f%n", applyDiscount);


    }


    public static void printMenu(List<Product> products) {

        for (int i = 0; i < products.size(); i++) {
            System.out.println(i + 1 + "- " + products.get(i).getName());
        }
        System.out.println("0- Bestellung abschließen!");
    }

    public static int readUserChoice(Scanner scanner, int max) {
        while (true) {
            System.out.println("Gib die Produktnummer ein (0 zum Beenden): ");
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input >= 0 && input <= max) {
                    return input;
                } else {
                    System.out.println("Ungültige Produktnummer.");
                }
            } else {
                System.out.println("Bitte gib eine gültige Zahl ein.");
                scanner.next();
            }


        }

    }


    public static void addToCart(Map<Product, Integer> cart, Product product) {
        cart.put(product, cart.getOrDefault(product, 0) + 1);

    }

    public static double printReceipt(Map<Product, Integer> cart) {
        double gesamt = 0.0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            Integer count = entry.getValue();
            gesamt += product.getPrice() * count;
            System.out.printf("%s : %d x $%.2f = %.2f", product.getName(), count, product.getPrice(), product.getPrice() * count);
            System.out.println();

        }
        System.out.printf("your receipt ---> total: $%.2f%n", gesamt);

        return gesamt;
    }

    public static double applyDiscount(double total) {

        if (total > 20.0) {
            double rabatt = total * 0.10;
            System.out.printf(" Rabatt: (10%%): -$%.2f%n", rabatt);
            return total - rabatt;


        }
        System.out.println("no rabatt for this order");
        return total;


    }

}



