package main.myProjects.toDoList.action;

import main.myProjects.toDoList.Input.Input;
import main.myProjects.toDoList.Output.Output;
import main.myProjects.toDoList.Task;
import main.myProjects.toDoList.toDoList;

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
