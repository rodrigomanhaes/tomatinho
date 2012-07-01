package tomatinho.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ToDoToday {
    private List<Task> tasks;

    public ToDoToday(Task... tasks) {
        this.tasks = new ArrayList<Task>(Arrays.asList(tasks));
    }
    
    public List<Task> tasks() {
        return Collections.unmodifiableList(tasks);
    }
    
    public void addItem(Task item) {
        tasks.add(item);
    }
    
    public Task currentOrNext() {
        for (Task task: tasks) {
            if (!task.finished())
                return task;
        }
        return null;
    }
}
