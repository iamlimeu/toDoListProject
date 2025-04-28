package main.myProjects.toDoList.action;

import main.myProjects.toDoList.Input.Input;
import main.myProjects.toDoList.Output.Output;
import main.myProjects.toDoList.actionStatus.ActionStatus;
import main.myProjects.toDoList.taskStatus.Status;
import main.myProjects.toDoList.LogicToDoList;
import java.util.Map;

public class StatisticsAction implements UserAction {
    private final Output output;

    public StatisticsAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Статистика задач по статусам и средний приоритет";
    }

    @Override
    public ActionStatus execute(Input input, LogicToDoList logicToDoList) {

        Map<Status, Integer> status = logicToDoList.getTasksStatusStatistics();
        double averagePriority = logicToDoList.getAveragePriority();
        output.println("Статистика задач:");
        output.println("- Выполнена: "
                + status.getOrDefault(Status.COMPLETED, 0));
        output.println("- В процессе: "
                + status.getOrDefault(Status.IN_WORK, 0));
        output.println("- Невыполнена: "
                + status.getOrDefault(Status.UNCOMPLETED, 0));
        output.println("Средний приориет: " + averagePriority);
        return ActionStatus.CONTINUE;
    }
}
