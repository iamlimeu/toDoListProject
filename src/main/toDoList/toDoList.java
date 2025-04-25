package main.toDoList;

import main.taskStatus.Status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;



public class toDoList {
    private final List<Task> tasks = new ArrayList<>();
    private int ids = 1;

    public Task add(Task task) {
        task.setId(ids++);
        tasks.add(task);
        return task;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < tasks.size(); index++) {
            if (tasks.get(index).getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public List<Task> showAllTasksByPriority() {
        return tasks.stream().sorted(Comparator.comparingInt((Task task) ->
                Optional.of(task.getPriority()).orElse(0)).reversed()).toList();
    }

    public List<Task> showAllTasksByCreatedDate() {
        return tasks.stream().sorted(Comparator.comparing((Task task) ->
                Optional.ofNullable(task.getCreatedTime()).orElse(LocalDateTime.now()))).toList();
    }

    public List<Task> findTaskByKeyword(String keyword) {
        return tasks.stream().filter(t ->
                t.getName() != null && t.getName().toLowerCase().contains(keyword.toLowerCase())).toList();
    }

    public List<Task> filterTasksByStatus(Status status) {
        return tasks.stream().filter(t -> t.getStatus().equals(status)).toList();
    }

    public List<Task> filterTasksByPriority(int from, int to) {
        return tasks.stream().filter(t -> t.getPriority() > from && t.getPriority() < to).toList();
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            tasks.remove(index);
        }
    }

    public Task findById(int id) {
        int index = indexOf(id);
        return index != -1 ? tasks.get(index) : null;
    }

    public boolean edit(int id, Task task) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            task.setId(id);
            tasks.set(index, task);
        }
        return result;
    }
}
