package tomatinho.core;

public class Tomatinho implements RingListener {
    private final ToDoToday toDoToday;
    private Task currentTask;
    private TomatoTimer timer;
    private final Configuration configuration;
    private final FlowController flow;

    public Tomatinho(ToDoToday todo, Configuration configuration) {
        this.toDoToday = todo;
        this.configuration = configuration;
        this.flow = new FlowController(configuration);
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
