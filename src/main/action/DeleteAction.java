package main.action;

import main.Input.Input;
import main.Output.Output;
import main.toDoList.Task;
import main.toDoList.toDoList;

public class DeleteAction implements UserAction{
    private final Output output;

    public DeleteAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Удалить задачу";
    }

    @Override
    public boolean execute(Input input, toDoList toDoList) {
        output.println("Удаление задачи");
        int id = input.askInt("Введите номер задачи: ");
        Task task = toDoList.findById(id);
        toDoList.delete(id);
        output.println(task != null ? "Задача успешно удалена" : "Ошибка удаления задачи");
        return true;
    }
}
