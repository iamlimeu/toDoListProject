package main.myProjects.toDoList.action;

import main.myProjects.toDoList.Input.Input;
import main.myProjects.toDoList.Output.Output;
import main.myProjects.toDoList.actionStatus.ActionStatus;
import main.myProjects.toDoList.taskStatus.Status;
import main.myProjects.toDoList.Task;
import main.myProjects.toDoList.LogicToDoList;
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
    public ActionStatus execute(Input input, LogicToDoList logicToDoList) {
        showFilterMenu();
        int choice = input.askInt("Выберите способ фильтрации задач: ");
        switch (choice) {
            case 1 -> filterByStatus(input, logicToDoList);
            case 2 -> filterByPriority(input, logicToDoList);
            default -> output.println("Неверный ввод");
        }
        return ActionStatus.CONTINUE;
    }

    private void showFilterMenu() {
        output.println("1. Фильтровать задачи по статусу: " +
                "\"Выполнена\", \"В процессе\", \"Невыполнена\"");
        output.println("2. Фильтровать задачи по диапазону приоритетов");
    }

    private void filterByStatus(Input input, LogicToDoList logicToDoList) {
        output.println("""
                Фильтрация задач по статусу.
                 \
                1. Выполнена
                 2. В процессе
                 3. Невыполнена""");
        int statusChoice = input.askInt("Введите номер желаемого статуса для фильтрации: ");
        switch (statusChoice) {
            case 1:
                Status status = Status.COMPLETED;
                logicToDoList.filterTasksByStatus(status).forEach(output::println);
                break;
            case 2:
                Status status2 = Status.IN_WORK;
                logicToDoList.filterTasksByStatus(status2).forEach(output::println);
                break;
            case 3:
                Status status3 = Status.UNCOMPLETED;
                logicToDoList.filterTasksByStatus(status3).forEach(output::println);
                break;
            default:
                output.println("Неверный ввод.");
        }
    }

    private void filterByPriority(Input input, LogicToDoList logicToDoList) {
        output.println("Фильтрация задач по диапазону приоритетов");
        int from = input.askInt("Введите цифру начала диапазона: ");
        int to = input.askInt("Введите цифру конца диапазона: ");
        List<Task> task = logicToDoList.filterTasksByPriority(from, to);
        if (task.isEmpty()) {
            output.println("Нет задач по заданному диапазону");
        } else {
            task.forEach(output::println);
        }
    }
}
