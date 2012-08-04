package tomatinho.core;

public class Tomato {
    private boolean finished;

    public Tomato() {
        finished = false;
    }

    public void finish() {
        finished = true;
    }

    public boolean finished() {
        return finished;
    }
}
