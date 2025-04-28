package main.myProjects.toDoList.action;

import main.myProjects.toDoList.Input.Input;
import main.myProjects.toDoList.Output.Output;
import main.myProjects.toDoList.Task;
import main.myProjects.toDoList.LogicToDoList;
import main.myProjects.toDoList.actionStatus.ActionStatus;

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
    public ActionStatus execute(Input input, LogicToDoList logicToDoList) {
        output.println("Редактирование задачи");
        int id = input.askInt("Введите номер задачи: ");
        String name = input.askStr("Введите желаемое имя задачи: ");
        int priority = input.askInt("Введите приоритет задачи: ");
        Task task = new Task(name, priority);
        output.println(logicToDoList.edit(id, task));
        if (logicToDoList.edit(id, task)) {
            output.println("Редактирование задачи успешно");
        } else {
            output.println("Ошибка при редактировании задачи");
        }
        return ActionStatus.CONTINUE;
    }
}
