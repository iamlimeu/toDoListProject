package main.taskForStream;

import java.util.Arrays;
import java.util.List;

public class Task10 {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Alice", "New York");
        Customer customer2 = new Customer("Bob", "Los Angeles");
        Customer customer3 = new Customer("Charlie", "New York");

        List<Order2> orders = Arrays.asList(
                new Order2(customer1, 100.0),
                new Order2(customer2, 200.0),
                new Order2(customer3, 150.0),
                new Order2(customer1, 250.0)
        );

        List<String> cities = orders.stream()
                .map(Order2::getCustomer)
                .map(Customer::getCity)
                .distinct()
                .toList();

        System.out.println(cities);
    }
}

class Customer {
    String name;
    String city;

    public Customer(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}

class Order2 {
    Customer customer;
    double amount;

    public Order2(Customer customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }
}
