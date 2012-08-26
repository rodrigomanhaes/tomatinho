package tomatinho.core;

public class Tomato {
    private boolean finished;
    private int externalInterruptionCount, internalInterruptionCount;

    public Tomato() {
        finished = false;
        externalInterruptionCount = 0;
        internalInterruptionCount = 0;
    }

    public void finish() {
        finished = true;
    }

    public boolean finished() {
        return finished;
    }

    public void externalInterruption() {
        externalInterruptionCount++;
    }

    public void internalInterruption() {
        internalInterruptionCount++;
    }

    public int externalInterruptionCount() {
        return externalInterruptionCount;
    }

    public int internalInterruptionCount() {
        return internalInterruptionCount;
    }

    public int interruptionCount() {
        return externalInterruptionCount() + internalInterruptionCount();
    }
}
