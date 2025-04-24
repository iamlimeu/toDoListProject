package main.taskForStream;

import java.util.Optional;

public class Task14 {
    public static void main(String[] args) {
        Product2 product1 = new Product2("Notebook", 1500.0);
        Product2 product2 = new Product2("Tablet", null);

        product1.getPrice().map(p -> p * 0.9).ifPresentOrElse(
                newPrice -> System.out.println("Цена продукта " + product1.getName() + " после скидки: " + newPrice),
                () -> System.out.println("Цена продукта " + product1.getName() + " не определена.")
        );
        product2.getPrice().map(p -> p * 0.9).ifPresentOrElse(
                newPrice -> System.out.println("Цена продукта " + product2.getName() + " после скидки: " + newPrice),
                () -> System.out.println("Цена продукта " + product2.getName() + " не определена.")
        );
    }
}

class Product2 {
    private String name;
    private Double price;

    public Product2(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Optional<Double> getPrice() {
        return Optional.ofNullable(price);
    }

    public String getName() {
        return name;
    }
}