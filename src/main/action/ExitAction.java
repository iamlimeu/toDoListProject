package main.action;

import main.Input.Input;
import main.Output.Output;
import main.toDoList.toDoList;

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
    public boolean execute(Input input, toDoList toDoList) {
        output.println("Завершение программы");
        return false;
    }
}
