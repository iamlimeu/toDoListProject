package main.myProjects.toDoList.action;

import main.myProjects.toDoList.Input.Input;
import main.myProjects.toDoList.Output.Output;
import main.myProjects.toDoList.Task;
import main.myProjects.toDoList.toDoList;

public class CreateAction implements UserAction {
    private final Output output;

    public CreateAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Добавить новую задачу";
    }

    @Override
    public boolean execute(Input input, toDoList toDoList) {
        output.println("Создание новой задачи");
        String name = input.askStr("Введите имя задачи: ");
        int priority = input.askInt("Введите приоритет задачи: ");
        Task task = new Task(name, priority);
        toDoList.add(task);
        output.println("Задача добавлена!");
        return true;
    }
}
