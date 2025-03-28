package main.action;

import main.Input.Input;
import main.Output.Output;
import main.taskStatus.Status;
import main.toDoList.Task;
import main.toDoList.toDoList;
import java.time.LocalDateTime;


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
        Task task = toDoList.findById(id);
        if (task == null) {
            output.println("Задача с таким номером не найдена");
        } else if (toDoList.edit(id, task)) {
            int choiceStatus = input.askInt("Выберите новый статус: ");
            Status updatedStatus = switch (choiceStatus) {
                case 1 -> Status.COMPLETED;
                case 2 -> Status.IN_WORK;
                case 3 -> Status.UNCOMPLETED;
                default -> throw new IllegalArgumentException("Неверный выбор");
            };
            task.setStatus(updatedStatus);
            if (updatedStatus == Status.COMPLETED) {
                task.setCompletionTime(LocalDateTime.now());
            } else {
                task.setCompletionTime(null);
            }
            output.println("Задача обновлена! Статус: " + updatedStatus.getStatus());
        }
        return true;
    }
}
