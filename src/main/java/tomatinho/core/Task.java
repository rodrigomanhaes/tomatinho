package tomatinho.core;

import java.util.*;

public class Task {
    private final String description;
    private boolean finished;
    private Date startTime;
    private String notes;
    private String type;
    private final List<Tomato> tomatoes;

    public Task(String description) {
        this.description = description;
        this.finished = false;
        this.tomatoes = new ArrayList<Tomato>();
    }

    public Tomato currentTomato() {
        for (Tomato tomato: tomatoes)
            if (!tomato.finished())
                return tomato;
        return null;
    }

    public void startTomato() {
        tomatoes.add(new Tomato());
    }

    public void finishTomato() {
        currentTomato().finish();
    }

    public int tomatoCount() {
        int count = 0;
        for (Tomato tomato: tomatoes)
            if (tomato.finished())
                count++;
        return count;
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

    public Task startTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Date startTime() {
        return startTime;
    }

    public Task notes(String notes) {
        this.notes = notes;
        return this;
    }

    public String notes() {
        return notes;
    }

    public Task type(String type) {
        this.type = type;
        return this;
    }

    public String type() {
        return type;
    }
}