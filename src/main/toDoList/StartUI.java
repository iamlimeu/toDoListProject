package main.toDoList;

import main.Input.ConsoleInput;
import main.Input.Input;
import main.Input.ValidateInput;
import main.Output.ConsoleOutput;
import main.Output.Output;
import main.action.*;
import java.util.Arrays;
import java.util.List;

public class StartUI {
    private final Output output;

    public StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, toDoList toDoList, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Выберите действие: ");
            if (select < 1 || select > actions.size()) {
                output.println("Неверный ввод - вы можете выбрать 1 .. " + (actions.size()));
                continue;
            }
            UserAction action = actions.get(select - 1);
            run = action.execute(input, toDoList);
        }
    }

    public void showMenu(List<UserAction> actions) {
        output.println("Меню:");
        for (int i = 0; i < actions.size(); i++) {
            output.println(i + 1 + ". " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        toDoList toDoList = new toDoList();
        List<UserAction> actions = Arrays.asList(
                new CreateAction(output),
                new EditAction(output),
                new EditStatusAction(output),
                new FindAllAction(output),
                new FindByKeywordAction(output),
                new DeleteAction(output),
                new FilterAction(output),
                new ExitAction(output)
        );
        StartUI startUI = new StartUI(output);
        startUI.init(input, toDoList, actions);

    }
}
