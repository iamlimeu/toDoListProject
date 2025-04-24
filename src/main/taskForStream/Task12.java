package main.taskForStream;

import java.util.Arrays;
import java.util.List;

public class Task12 {
    public static void main(String[] args) {
        Employee2 e1 = new Employee2("Alice", 5000);
        Employee2 e2 = new Employee2("Bob", 6000);
        Employee2 e3 = new Employee2("Charlie", 5500);

        Department2 department = new Department2("IT", Arrays.asList(e1, e2, e3));

        double totalSalary = department.getEmployees().stream()
                .mapToDouble(Employee2::getSalary)
                .sum();

        System.out.println("Total salary of all employees: " + totalSalary);
    }
}

class Employee2 {
    String name;
    double salary;

    Employee2(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

class Department2 {
    String name;
    List<Employee2> employees;

    Department2(String name, List<Employee2> employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public List<Employee2> getEmployees() {
        return employees;
    }
}