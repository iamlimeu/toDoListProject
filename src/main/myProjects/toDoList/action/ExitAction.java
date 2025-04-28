package main.myProjects.toDoList.action;

import main.myProjects.toDoList.Input.Input;
import main.myProjects.toDoList.Output.Output;
import main.myProjects.toDoList.LogicToDoList;
import main.myProjects.toDoList.actionStatus.ActionStatus;

public class ExitAction implements UserAction{
    private final Output output;

    public ExitAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Завершить программу";
    }

    @Override
    public ActionStatus execute(Input input, LogicToDoList logicToDoList) {
        output.println("Завершение программы");
        return ActionStatus.EXIT;
    }
}
