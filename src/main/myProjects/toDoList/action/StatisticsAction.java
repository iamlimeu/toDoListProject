package main.myProjects.toDoList.action;

import main.myProjects.toDoList.Input.Input;
import main.myProjects.toDoList.Output.Output;
import main.myProjects.toDoList.taskStatus.Status;
import main.myProjects.toDoList.toDoList;

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
    public boolean execute(Input input, toDoList toDoList) {

        Map<Status, Integer> status = toDoList.getTasksStatusStatistics();
        double averagePriority = toDoList.getAveragePriority();
        output.println("Статистика задач:");
        output.println("- Выполнена: " + status.getOrDefault(Status.COMPLETED, 0));
        output.println("- В процессе: " + status.getOrDefault(Status.IN_WORK, 0));
        output.println("- Невыполнена: " + status.getOrDefault(Status.UNCOMPLETED, 0));
        output.println("Средний приориет: " + averagePriority);
        return true;
    }
}
