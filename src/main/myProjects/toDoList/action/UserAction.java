package main.myProjects.toDoList.action;

import main.myProjects.toDoList.Input.Input;
import main.myProjects.toDoList.toDoList;

public interface UserAction {
    String name();

    boolean execute(Input input, toDoList toDoList);
}
