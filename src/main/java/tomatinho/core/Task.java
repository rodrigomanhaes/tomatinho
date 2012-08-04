package tomatinho.core;

import java.util.Date;

public class Task {
    private final String description;
    private boolean finished;
    private Date startTime;
    private String notes;
    private String type;

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