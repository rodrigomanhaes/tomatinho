package tomatinho.core;

public class Task {
    private String description;
    private boolean finished;
    
    public Task(String description) {
        this.description = description;
        this.finished = false;
    }
    
    public boolean finished() {
        return finished;
    }

    public void finish() {
        finished = true;
    }
    
    public String description() {
        return description;
    }
}
