package main.action;

import main.Input.Input;
import main.Output.Output;
import main.toDoList.Task;
import main.toDoList.toDoList;

import java.util.List;

public class FindAllAction implements UserAction {
    private final Output output;

    public FindAllAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать все задачи";
    }

    @Override
    public boolean execute(Input input, toDoList toDoList) {
        output.println("Список задач");
        List<Task> tasks = toDoList.showAll();
        if (!tasks.isEmpty()) {
            for (Task task : tasks) {
                System.out.println(task);
            }
        } else {
            output.println("Задачи отсутствуют");
        }
        return true;
    }
}
