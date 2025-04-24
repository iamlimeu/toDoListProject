package main.taskForStream;

import java.util.Arrays;
import java.util.List;

public class Task7 {
    public static void main(String[] args) {
        List<Department> departments = Arrays.asList(
                new Department("HR", Arrays.asList(
                        new Employee("Alice", 50000),
                        new Employee("Bob", 60000)
                )),
                new Department("IT", Arrays.asList(
                        new Employee("Charlie", 70000),
                        new Employee("David", 80000)
                ))
        );

        List<String> result = departments.stream()
                .flatMap(e -> e.getEmployees().stream())
                .map(Employee::getName)
                .toList();

        System.out.println(result);
    }
}

class Department {
    String name;
    List<Employee> employees;

    public Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
