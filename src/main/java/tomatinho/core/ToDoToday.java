package tomatinho.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ToDoToday {
    private List<String> tasks;

    public ToDoToday(String... tasks) {
        this.tasks = Arrays.asList(tasks);
    }
    
    public List<String> tasks() {
        return Collections.unmodifiableList(tasks);
    }
}
