package main.action;

import main.Input.Input;
import main.Output.Output;
import main.toDoList.Task;
import main.toDoList.toDoList;

public class EditAction implements UserAction {
    private final Output output;

    public EditAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Редактировать задачу";
    }

    @Override
    public boolean execute(Input input, toDoList toDoList) {
        output.println("Редактирование задачи");
        int id = input.askInt("Введите номер задачи: ");
        String name = input.askStr("Введите желаемое имя задачи: ");
        int priority = input.askInt("Введите приоритет задачи: ");
        Task task = new Task(name, priority);
        if (toDoList.edit(id, task)) {
            output.println("Редактирование задачи успешно");
        } else {
            output.println("Ошибка при редактировании задачи");
        }
        return true;
    }
}
