package main.taskForStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("A001", 150.0),
                new Order("A002", 75.0),
                new Order("A003", 200.0),
                new Order("A004", 50.0)
        );

        List<String> ordersHigherThan100 = orders.stream()
                .filter(o -> o.getTotal() > 100.0)
                .map(Order::getId)
                .collect(Collectors.toList());

        System.out.println(ordersHigherThan100);
    }
}

class Order {
    String id;
    double total;

    public Order(String id, double total) {
        this.id = id;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }
}