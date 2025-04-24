package main.taskForStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 800.0),
                new Product("Smartphone", 600.0),
                new Product("Tablet", 400.0),
                new Product("Smartwatch", 200.0)
        );
        products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .map(Product::getName)
                .forEach(System.out::println);
    }
}

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
