package main.taskForStream;

import java.util.Arrays;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("John", 85),
                new Student("Sarah", 92),
                new Student("Paul", 78),
                new Student("Emma", 88)
        );
        boolean HasHigherScoreThan90 = students.stream()
                .anyMatch(s -> s.getScore() > 90);

        System.out.println(HasHigherScoreThan90);
    }
}

class Student {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}