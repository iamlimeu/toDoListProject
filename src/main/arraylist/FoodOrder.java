package main.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodOrder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> dishes = new ArrayList<>();
        List<Double> prices = new ArrayList<>();
        System.out.print("Введите количество заказов: ");
        int orderQuantity = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= orderQuantity; i++) {
            System.out.print("Введите название блюда " + i + ": ");
            String dish = scanner.nextLine();
            System.out.print("Введите цену блюда " + i + ": ");
            double price = scanner.nextDouble();
            scanner.nextLine();
            dishes.add(dish);
            prices.add(price);
        }
        System.out.println("Список заказанных блюд:");
        double total = 0.0;
        for (int i = 0; i < dishes.size(); i++) {
            System.out.printf("%d. %s — %.2f\n", (i + 1), dishes.get(i), prices.get(i));
            total += prices.get(i);
        }
        System.out.println("Общая стоимость заказов: " + total);
        scanner.close();
    }
}
