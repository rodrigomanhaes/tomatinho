package tomatinho.core;

import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TomatoTimer {

    private List<RingListener> listeners;

    public TomatoTimer(RingListener... listeners) {
        this.listeners = Arrays.asList(listeners);
    }

    public void start(int seconds) {
        Timer timer = new Timer();
        timer.schedule(
            new TimerTask() {
                @Override
                public void run() {
                    for (RingListener listener: listeners)
                        listener.ring();
                }
            },
            seconds * 1000
        );
    }
}
