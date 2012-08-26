package tomatinho.core;

import java.util.*;

public class ToDoToday {
    private final List<Task> tasks;
    private final List<Task> unplannedTasks;
    private String owner;
    private String local;
    private Date date;

    public ToDoToday(Task... tasks) {
        this.tasks = new ArrayList<Task>(Arrays.asList(tasks));
        unplannedTasks = new ArrayList<Task>();
    }

    public List<Task> tasks() {
        return Collections.unmodifiableList(tasks);
    }

    public List<Task> unplannedTasks() {
        return unplannedTasks;
    }

    public void addTask(Task item) {
        tasks.add(item);
    }

    public void addUnplannedTask(Task task) {
        unplannedTasks.add(task);
    }

    public Task currentOrNext() {
        for (Task task: tasks) {
            if (!task.finished())
                return task;
        }
        return null;
    }

    public ToDoToday owner(String owner) {
        this.owner = owner;
        return this;
    }

    public String owner() {
        return owner;
    }

    public ToDoToday local(String local) {
        this.local = local;
        return this;
    }

    public String local() {
        return local;
    }

    public ToDoToday date(Date date) {
        this.date = date;
        return this;
    }

    public Date date() {
        return date;
    }
}