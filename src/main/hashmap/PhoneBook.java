package main.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> contactInfo = new HashMap<>();
        System.out.print("Сколько номеров вы хотите добавить? ");
        int quantityContacts = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < quantityContacts; i++) {
            System.out.print("Введите имя: ");
            String name = scanner.nextLine();
            System.out.print("Введите номер телефона: ");
            String number = scanner.nextLine();
            contactInfo.put(name, number);
        }
        System.out.println();
        System.out.print("Введите имя, чей номер хотите найти: ");
        String findNumberByName = scanner.nextLine();
        if (contactInfo.containsKey(findNumberByName)) {
            String number = contactInfo.get(findNumberByName);
            System.out.println("Номер для " + findNumberByName + " : " + number);
        } else {
            System.out.println("Контакт с именем " + findNumberByName + " не найден");
        }
        scanner.close();
    }
}
