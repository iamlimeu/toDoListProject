package main.myProjects.toDoList.action;

import main.myProjects.toDoList.Input.Input;
import main.myProjects.toDoList.Output.Output;
import main.myProjects.toDoList.taskStatus.Status;
import main.myProjects.toDoList.Task;
import main.myProjects.toDoList.toDoList;

import java.util.List;

public class FilterAction implements UserAction {
    private final Output output;

    public FilterAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Фильтрация задач";
    }

    @Override
    public boolean execute(Input input, toDoList toDoList) {
        output.println("1. Фильтровать задачи по статусу: \"Выполнена\", \"В процессе\", \"Невыполнена\"");
        output.println("2. Фильтровать задачи по диапазону приоритетов");
        int choice = input.askInt("Выберите способ фильтрации задач: ");
        if (choice == 1) {
                output.println("Фильтрация задач по статусу.\n 1. Выполнена\n 2. В процессе\n 3. Невыполнена");
                int statusChoice = input.askInt("Введите номер желаемого статуса для фильтрации: ");
                switch (statusChoice) {
                    case 1:
                        Status status = Status.COMPLETED;
                        toDoList.filterTasksByStatus(status).forEach(System.out::println);
                        break;
                    case 2:
                        Status status2 = Status.IN_WORK;
                        toDoList.filterTasksByStatus(status2).forEach(System.out::println);
                        break;
                    case 3:
                        Status status3 = Status.UNCOMPLETED;
                        toDoList.filterTasksByStatus(status3).forEach(System.out::println);
                        break;
                    default:
                        output.println("Неверный ввод.");
                }
        } else if (choice == 2) {
            output.println("Фильтрация задач по диапазону приоритетов");
            int from = input.askInt("Введите цифру начала диапазона: ");
            int to = input.askInt("Введите цифру конца диапазона: ");
            List<Task> task = toDoList.filterTasksByPriority(from, to);
            if (task.isEmpty()) {
                output.println("Нет задач по заданному диапазону");
            } else {
                task.forEach(System.out::println);
            }
        } else {
            output.println("Неверный ввод");
        }
        return true;
    }
}
