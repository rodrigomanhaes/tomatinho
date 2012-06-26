package tomatinho.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ToDoToday {
    private List<String> tasks;

    public ToDoToday(String... tasks) {
        this.tasks = new ArrayList<String>(Arrays.asList(tasks));
    }
    
    public List<String> tasks() {
        return Collections.unmodifiableList(tasks);
    }
    
    public void addItem(String item) {
        tasks.add(item);
    }
}
