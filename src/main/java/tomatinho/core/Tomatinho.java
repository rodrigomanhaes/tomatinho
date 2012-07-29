package tomatinho.core;

import static tomatinho.core.Status.*;

public class Tomatinho implements RingListener {

    private ToDoToday toDoToday;
    private Task currentTask;
    private TomatoTimer timer;
    private Configuration configuration;
    private Status.FlowController flow;

    public Tomatinho(ToDoToday todo, Configuration configuration) {
        this.toDoToday = todo;
        this.configuration = configuration;
        this.flow = Status.newFlowController(configuration);
    }
    
    public void start() {
        currentTask = toDoToday.currentOrNext();
        timer = new TomatoTimer(this);
        timer.start(configuration.workTime());
        flow.next();
    }

    public Task currentTask() {
        return currentTask;
    }

    public Status status() {
        return flow.current();
    }

    @Override
    public void ring() {
        flow.next();
    }
}
