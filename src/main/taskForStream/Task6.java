package main.taskForStream;

import java.util.Arrays;
import java.util.List;

public class Task6 {
    public static void main(String[] args) {
        List<Invoice> invoices = Arrays.asList(
                new Invoice(250.50),
                new Invoice(125.75),
                new Invoice(175.25),
                new Invoice(300.00)
        );

        double total = invoices.stream()
                .mapToDouble(Invoice::getAmount)
                .sum();
        System.out.println("Total amount: " + total);
    }
}

class Invoice {
    double amount;

    public Invoice(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
