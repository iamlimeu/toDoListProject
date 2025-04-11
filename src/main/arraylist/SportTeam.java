package main.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SportTeam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        List<Byte> numbers = new ArrayList<>();
        System.out.print("Сколько игроков вы хотите добавить? ");
        int countPlayers = scanner.nextByte();
        scanner.nextLine();
        for (int i = 1; i <= countPlayers; i++) {
            System.out.print("Введите имя игрока " + i + ": ");
            String name = scanner.nextLine();
            System.out.print("Введите номер игрока " + i + ": ");
            Byte number = scanner.nextByte();
            scanner.nextLine();
            names.add(name);
            numbers.add(number);
        }
        System.out.println();
        System.out.println("Состав команды:");
        byte totalPlayers = (byte) names.size();
        for (int i = 0; i < numbers.size(); i++) {
            System.out.printf("%d. %s (№%d)\n", i + 1, names.get(i), numbers.get(i));
        }
        System.out.println();
        System.out.println("Всего игроков: " + totalPlayers);
        System.out.println();

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1 - Удалить игрока по индексу");
            System.out.println("2 - Найти игрока по номеру");
            System.out.println("3 - Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    deletePlayer(names, numbers, scanner);
                    break;
                case 2: findByNumber(numbers, names, scanner);
                    break;
                case 3:
                    System.out.println("Завершение программы");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверное действие. Попробуйте снова");

            }
        }
    }

    private static void deletePlayer(List<String> names, List<Byte> numbers, Scanner scanner) {
        System.out.print("Введите индекс игрока для удаления: (1 - " + names.size() + ") : ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index < 1 || index > names.size()) {
            System.out.println("Неверный ввод индекса. Попробуйте еще раз");
            return;
        }
        int actualIndex = index - 1;
        String removedName = names.remove(actualIndex);
        Byte removedNumber = numbers.remove(actualIndex);
        System.out.println("Игрок " + removedName + " c №%" + removedNumber + " успешно удален");
        System.out.println("Обновленный состав команды:");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.printf("%d. %s (№%d)\n", i + 1, names.get(i), numbers.get(i));
        }
        System.out.println("Всего игроков: " + names.size());
    }

    private static void findByNumber(List<Byte> numbers, List<String> names, Scanner scanner) {
        System.out.print("Введите номер игрока для поиска: ");
        byte searchNumber = scanner.nextByte();
        scanner.nextLine();
        for (int i = 0; i < names.size(); i++) {
            if (searchNumber == numbers.get(i)) {
                System.out.println("Игрок с номером " + numbers.get(i) + ": " + names.get(i));
            }
        }
    }
}
