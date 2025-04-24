package main.taskForStream;

import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 40),
                new Person("Charlie", 25),
                new Person("David", 35)
        );
        people.stream()
                .filter(p -> p.getAge() > 30)
                .map(Person::getName)
                .forEach(System.out::println);
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
