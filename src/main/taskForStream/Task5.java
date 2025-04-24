package main.taskForStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 50000),
                new Employee("Bob", 60000),
                new Employee("Charlie", 55000),
                new Employee("David", 70000)
        );

        Employee result = employees.stream()
                        .min(Comparator.comparingInt(Employee::getSalary))
                        .get();

        System.out.println("Наименьшая зарплата у " + result.getName() + " : " + result.getSalary());
    }
}

class Employee {
    String name;
    int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
}