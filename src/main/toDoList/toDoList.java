package main.toDoList;

import java.util.ArrayList;
import java.util.List;

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

    public List<Task> showAll() {
        return List.copyOf(tasks);
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
