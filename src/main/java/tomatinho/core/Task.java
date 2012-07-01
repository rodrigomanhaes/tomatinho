package tomatinho.core;

public class Task {
    private String description;
    
    public Task(String description) {
        this.description = description;
    }
    
    public boolean finished() {
        return false;
    }
}
