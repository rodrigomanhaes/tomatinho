package tomatinho.core;

import static tomatinho.core.Status.*;

public class Tomatinho implements RingListener {

    private ToDoToday toDoToday;
    private Task currentTask;
    private TomatoTimer timer;
    private Configuration configuration;
    private Status status;
    
    public Tomatinho(ToDoToday todo, Configuration configuration) {
        this.toDoToday = todo;
        this.configuration = configuration;
        status = WAITING; 
    }
    
    public void start() {
        currentTask = toDoToday.currentOrNext();
        timer = new TomatoTimer(this);
        timer.start(configuration.workTime());
        status = WORKING;
    }

    public Task currentTask() {
        return currentTask;
    }
    
    public Status status() {
        return status;
    }

    @Override
    public void ring() {
        status = WAITING;
    }
}
