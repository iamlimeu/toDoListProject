package main.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdvancedPhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, ArrayList<String>> phoneBook = new HashMap<>();
        System.out.print("Сколько телефонных записей вы хотите добавить? ");
        int entryQuantity = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < entryQuantity; i++) {
            System.out.print("Введите имя контакта: ");
            String name = scanner.nextLine();
            System.out.print("Введите номер телефона: ");
            String number = scanner.nextLine();
            if (!phoneBook.containsKey(name)) {
                ArrayList<String> numbers = new ArrayList<>();
                numbers.add(number);
                phoneBook.put(name, numbers);
            } else {
                phoneBook.get(name).add(number);
            }
        }
        System.out.println();
        System.out.print("Введите имя контакта для поиска: ");
        String findByName = scanner.nextLine();
        System.out.println("Телефонные номера для " + findByName);
        ArrayList<String> numberByName = phoneBook.get(findByName);
        for (String number : numberByName) {
            System.out.println("- " + number);
        }
        System.out.println();
        System.out.println("Полный список контактов:");
        for (Map.Entry<String, ArrayList<String>> entry : phoneBook.entrySet()) {
            System.out.printf("%s: %s\n", entry.getKey(), entry.getValue().toString());
        }
    }
}
