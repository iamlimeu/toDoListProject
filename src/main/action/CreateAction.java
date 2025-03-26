package main.action;

import main.Input.Input;
import main.Output.Output;
import main.toDoList.Task;
import main.toDoList.toDoList;

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
