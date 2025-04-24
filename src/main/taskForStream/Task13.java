package main.taskForStream;

import java.util.Arrays;
import java.util.List;

public class Task13 {
    public static void main(String[] args) {
        Employee3 e1 = new Employee3("Alice", 60000);
        Employee3 e2 = new Employee3("Bob", 45000);
        Employee3 e3 = new Employee3("Charlie", 70000);

        Department3 department = new Department3(Arrays.asList(e1, e2, e3));

        List<Department3> departments = Arrays.asList(department);

        departments.stream()
                .flatMap(d -> d.getEmployeesWithSalaryAbove(50000).stream())
                .forEach(System.out::println);
    }
}

class Employee3 {
    String name;
    int salary;

    Employee3(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return  name;
    }

    public int getSalary() {
        return salary;
    }
}

class Department3 {
    List<Employee3> employees;

    Department3(List<Employee3> employees) {
        this.employees = employees;
    }

    public List<String> getEmployeesWithSalaryAbove(int salary) {
        return employees.stream().filter(e -> e.getSalary() > salary).map(Employee3::getName).toList();
    }
}
