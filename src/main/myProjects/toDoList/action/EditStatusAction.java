package main.myProjects.toDoList.action;

import main.myProjects.toDoList.Input.Input;
import main.myProjects.toDoList.Output.Output;
import main.myProjects.toDoList.actionStatus.ActionStatus;
import main.myProjects.toDoList.taskStatus.Status;
import main.myProjects.toDoList.Task;
import main.myProjects.toDoList.LogicToDoList;
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
    public ActionStatus execute(Input input, LogicToDoList logicToDoList) {
        output.println("Изменение статуса задачи");
        int id = input.askInt("Введите номер задачи: ");
        output.println("1. Выполнена");
        output.println("2. В процессе");
        output.println("3. Невыполнена");
        Task task = logicToDoList.findById(id);
        if (task == null) {
            output.println("Задача с таким номером не найдена");
            return ActionStatus.CONTINUE;
        }
        if (logicToDoList.edit(id, task)) {
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
                output.println("Задача обновлена! Статус: " + updatedStatus.getStatus() +
                        ", Время выполнения: " + task.getCompletionTime());
            } else {
                task.setCompletionTime(null);
                output.println("Задача обновлена! Статус: " + updatedStatus.getStatus());
            }
        }
        return ActionStatus.CONTINUE;
    }
}
