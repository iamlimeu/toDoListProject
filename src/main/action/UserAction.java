package main.action;

import main.Input.Input;
import main.toDoList.toDoList;

public interface UserAction {
    String name();

    boolean execute(Input input, toDoList toDoList);
}
