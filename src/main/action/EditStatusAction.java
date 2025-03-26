package main.action;

import main.Input.Input;
import main.Output.Output;
import main.toDoList.Task;
import main.toDoList.toDoList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EditStatusAction implements UserAction{
    private final Output output;

    public EditStatusAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Изменить статус задачи";
    }

    @Override
    public boolean execute(Input input, toDoList toDoList) {
        output.println("Изменение статуса задачи");
        int id = input.askInt("Введите номер задачи: ");
        output.println("1. Выполнена");
        output.println("2. В процессе");
        output.println("3. Невыполнена");
        int status = input.askInt("Выберите новый статус: ");
        Task task = new Task(status);
        if (toDoList.edit(id, task)) {
            switch (status) {
                case 1 -> output.println("Задача обновлена! Статус: " + Task.Status.ВЫПОЛНЕНА + ", Время выполнения: "
                            + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
                case 2 -> output.println("Задача обновлена! Статус: " + Task.Status.В_ПРОЦЕССЕ);
                case 3 -> output.println("Задача обновлена! Статус: " + Task.Status.НЕВЫПОЛНЕНА + ", Время выполнения: Отсутствует");
                default -> output.println("Ошибка изменения статуса задачи");
            }
        }
        return true;
    }
}
