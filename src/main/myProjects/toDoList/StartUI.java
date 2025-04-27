package main.myProjects.toDoList;

import main.myProjects.toDoList.Input.ConsoleInput;
import main.myProjects.toDoList.Input.Input;
import main.myProjects.toDoList.Input.ValidateInput;
import main.myProjects.toDoList.Output.ConsoleOutput;
import main.myProjects.toDoList.Output.Output;
import main.myProjects.toDoList.action.*;
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
                new DeleteAction(output),
                new EditAction(output),
                new EditStatusAction(output),
                new FindAllAction(output),
                new FilterAction(output),
                new FindByKeywordAction(output),
                new StatisticsAction(output),
                new ExitAction(output)
        );
        StartUI startUI = new StartUI(output);
        startUI.init(input, toDoList, actions);

    }
}
