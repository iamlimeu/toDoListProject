package main.myProjects.toDoList.action;

import main.myProjects.toDoList.Input.Input;
import main.myProjects.toDoList.LogicToDoList;
import main.myProjects.toDoList.actionStatus.ActionStatus;

public interface UserAction {
    String name();

    ActionStatus execute(Input input, LogicToDoList logicToDoList);
}
