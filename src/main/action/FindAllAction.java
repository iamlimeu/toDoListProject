package main.action;

import main.Input.Input;
import main.Output.Output;
import main.toDoList.toDoList;


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
        output.println("1. Показать все задачи с сортировкой по приоритету (по убыванию).");
        output.println("2. Показать все задачи с сортировкой по дате создания.");
        int choice = input.askInt("Выберите по какому параметру отобразить список задач: ");
        switch (choice) {
            case 1:
                output.println("Оторажение задач по приоритету (по убыванию):");
                toDoList.showAllTasksByPriority().forEach(System.out::println);
                break;
            case 2:
                output.println("Отображение задач по дате создания:");
                toDoList.showAllTasksByCreatedDate().forEach(System.out::println);
                break;
            default:
                output.println("Пока не было создано ни одной задачи.");
        }
        return true;
    }
}
