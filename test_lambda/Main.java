package test_lambda;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = List.of(
            new Product("Laptop",      "Electronique",  999.99),
            new Product("Souris",      "Electronique",   29.99),
            new Product("Bureau",      "Mobilier",      249.00),
            new Product("Chaise",      "Mobilier",      149.00),
            new Product("Clavier",     "Electronique",   59.99),
            new Product("Lampe",       "Mobilier",       39.99),
            new Product("Ecouteurs",   "Electronique",   89.99),
            new Product("Webcam",      "Electronique",   79.99)
        );

        // --- filter ---
        System.out.println("=== Produits Electronique ===");
        List<Product> electronique = products.stream()
            .filter(p -> p.getCategory().equals("Electronique"))
            .collect(Collectors.toList());
        electronique.forEach(System.out::println);

        System.out.println("\n=== Produits < 100€ ===");
        products.stream()
            .filter(p -> p.getPrice() < 100)
            .forEach(System.out::println);

        // --- map ---
        System.out.println("\n=== Noms des produits ===");
        List<String> noms = products.stream()
            .map(Product::getName)
            .collect(Collectors.toList());
        System.out.println(noms);

        System.out.println("\n=== Prix avec TVA (20%) ===");
        products.stream()
            .map(p -> p.getName() + " -> " + Math.round(p.getPrice() * 1.20 * 100.0) / 100.0 + "€")
            .forEach(System.out::println);

        // --- sorted ---
        System.out.println("\n=== Produits triés par prix (croissant) ===");
        products.stream()
            .sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
            .forEach(System.out::println);

        System.out.println("\n=== Produits triés par nom ===");
        products.stream()
            .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
            .forEach(System.out::println);

        // --- reduce ---
        System.out.println("\n=== Prix total de tous les produits ===");
        double total = products.stream()
            .map(Product::getPrice)
            .reduce(0.0, Double::sum);
        System.out.println("Total : " + total + "€");

        System.out.println("\n=== Prix total Electronique ===");
        double totalElectronique = products.stream()
            .filter(p -> p.getCategory().equals("Electronique"))
            .map(Product::getPrice)
            .reduce(0.0, Double::sum);
        System.out.println("Total Electronique : " + totalElectronique + "€");

        System.out.println("\n=== Produit le plus cher ===");
        products.stream()
            .reduce((p1, p2) -> p1.getPrice() > p2.getPrice() ? p1 : p2)
            .ifPresent(p -> System.out.println("Le plus cher : " + p));
    }
}
