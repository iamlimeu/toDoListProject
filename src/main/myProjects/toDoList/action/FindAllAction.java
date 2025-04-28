package main.myProjects.toDoList.action;

import main.myProjects.toDoList.Input.Input;
import main.myProjects.toDoList.Output.Output;
import main.myProjects.toDoList.LogicToDoList;
import main.myProjects.toDoList.actionStatus.ActionStatus;


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
    public ActionStatus execute(Input input, LogicToDoList logicToDoList) {
        output.println("1. Показать все задачи с сортировкой по приоритету (по убыванию).");
        output.println("2. Показать все задачи с сортировкой по дате создания.");
        int choice = input.askInt("Выберите по какому параметру отобразить список задач: ");
        switch (choice) {
            case 1:
                output.println("Оторажение задач по приоритету (по убыванию):");
                logicToDoList.showAllTasksByPriority().forEach(output::println);
                break;
            case 2:
                output.println("Отображение задач по дате создания:");
                logicToDoList.showAllTasksByCreatedDate().forEach(output::println);
                break;
            default:
                output.println("Пока не было создано ни одной задачи.");
        }
        return ActionStatus.CONTINUE;
    }
}
