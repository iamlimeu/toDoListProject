package main.toDoList;

import main.taskStatus.Status;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private int id;
    private String name;
    private int priority;
    private Status status = Status.UNCOMPLETED;
    private LocalDateTime time = LocalDateTime.now();
    private LocalDateTime completionTime;
    private static final DateTimeFormatter CREATED_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Task() { }

    public Task(String name) {
        this.name = name;
    }

    public Task(Status status) {
        this.status = status;
    }

    public Task(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Task(String name, int priority, Status status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Status setStatus(Status status) {
        return this.status = status;

    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setCompletionTime(LocalDateTime time) {
        this.completionTime = time;
    }

    public LocalDateTime getCompletionTime() {
        return completionTime;
    }

    @Override
    public String toString() {
        String completionTimeResult = completionTime != null ?
                completionTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) : "Отсутствует";

        return  id + ". " + name + " | "
                + "Приоритет: " + priority + " | "
                + "Статус: "  + status.getStatus() + " | "
                + "Дата создания: " + time.format(CREATED_FORMATTER) + " | "
                + "Время выполнения: " + completionTimeResult;
    }
}
