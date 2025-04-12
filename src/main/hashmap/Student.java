package main.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Student {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> subjects = new HashMap<>();
        System.out.print("Сколько предметов вы хотите ввести? ");
        int quantityOfSubjects = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= quantityOfSubjects; i++) {
            System.out.print("Введите название предмета " + i + ": ");
            String name = scanner.nextLine();
            System.out.print("Введите балл (0-100): ");
            int grade = scanner.nextInt();
            subjects.put(name, grade);
            scanner.nextLine();
        }
        System.out.println();
        System.out.println("Введённые данные:");
        int totalGrades = 0;
        int counter = 0;
        for (Map.Entry<String, Integer> entry : subjects.entrySet()) {
            System.out.printf("-%s: %d\n", entry.getKey(), entry.getValue());
            totalGrades += entry.getValue();
            counter++;
        }
        System.out.println();
        double avgGrade =(double) totalGrades / counter;
        System.out.printf("%s : %.4f" ,"Средний балл ", avgGrade);
    }
}
