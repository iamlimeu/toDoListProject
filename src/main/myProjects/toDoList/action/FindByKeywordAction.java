package main.myProjects.toDoList.action;

import main.myProjects.toDoList.Input.Input;
import main.myProjects.toDoList.Output.Output;
import main.myProjects.toDoList.Task;
import main.myProjects.toDoList.toDoList;

import java.util.List;

public class FindByKeywordAction implements UserAction {
    private final Output output;

    public FindByKeywordAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Найти задачу по ключевому слову";
    }

    @Override
    public boolean execute(Input input, toDoList toDoList) {
        output.println("Поиск задачи по ключевому слову");
        String keyword = input.askStr("Введите ключевое слово: ");
        List<Task> task = toDoList.findTaskByKeyword(keyword);
        if (task.isEmpty()) {
            System.out.println("Задача не найдена по данному ключевому слову");
        } else {
            task.forEach(System.out::println);
        }
        return true;
    }
}
