package main.myProjects.toDoList.actionStatus;

public enum ActionStatus {
    EXIT("Завершение работы программы"),
    CONTINUE("");

    private final String actionStatus;

    ActionStatus(String actionStatus) {
        this.actionStatus = actionStatus;
    }

    public String getActionStatus() {
        return actionStatus;
    }
}
