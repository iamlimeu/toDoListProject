package main.toDoList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private int id;
    private String name;
    private int priority;
    private int status;
    private LocalDateTime time = LocalDateTime.now();
    private static final DateTimeFormatter CREATED_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Task() { }

    public Task(String name) {
        this.name = name;
    }

    public Task(int status) {
        this.status = status;
    }

    public Task(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Task(String name, int priority, int status) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public enum Status {
        ВЫПОЛНЕНА,
        В_ПРОЦЕССЕ,
        НЕВЫПОЛНЕНА
    }

    @Override
    public String toString() {
        return  id + ". " + name + " | "
                + "Приоритет: " + priority + " | "
                + "Статус: "  + Status.НЕВЫПОЛНЕНА + " | "
                + "Дата создания: " + time.format(CREATED_FORMATTER) + " | "
                + "Время выполнения: отсутствует";
    }
}
