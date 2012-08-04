package tomatinho.core;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static tomatinho.core.Status.*;

import org.junit.*;

public class TomatinhoTest {

    protected Task task1, task2, task3;
    protected ToDoToday todo;

    @Before
    public void setup() {
        task1 = new Task("Task 1");
        task2 = new Task("Task 2");
        task3 = new Task("Task 3");

        todo = new ToDoToday(task1, task2, task3);
    }

    @Test
    public void controlsApplicationFlow() throws InterruptedException {
        Configuration configuration = Configuration.builder()
            .workTime(0.02)
            .longBreak(0.02)
            .shortBreak(0.02)
            .longBreakInterval(2)
            .build();
        Tomatinho tomatinho = new Tomatinho(todo, configuration);

        assertThat(tomatinho.currentTask(), is(equalTo(null)));
        assertThat(tomatinho.status(), is(equalTo(null)));

        tomatinho.start();
        assertThat(tomatinho.currentTask(), is(task1));
        assertThat(tomatinho.status(), is(WORKING));

        Thread.sleep(Math.round(1000 * 0.03));
        assertThat(tomatinho.status(), is(WAITING));
        tomatinho.start();
        assertThat(tomatinho.status(), is(SHORT_BREAK));

        Thread.sleep(Math.round(1000 * 0.03));
        assertThat(tomatinho.status(), is(WAITING));
        tomatinho.start();
        assertThat(tomatinho.status(), is(WORKING));
        assertThat(tomatinho.currentTask(), is(task1));

        Thread.sleep(Math.round(1000 * 0.03));
        assertThat(tomatinho.status(), is(WAITING));
        tomatinho.start();
        assertThat(tomatinho.status(), is(LONG_BREAK));

        task1.finish();
        Thread.sleep(Math.round(1000 * 0.03));
        assertThat(tomatinho.status(), is(WAITING));
        tomatinho.start();
        assertThat(tomatinho.status(), is(WORKING));
        assertThat(tomatinho.currentTask(), is(task2));
    }

    @Test
    public void controlsContinuousApplicationFlow() throws InterruptedException {
        Configuration configuration = Configuration.builder()
            .workTime(0.02)
            .longBreak(0.02)
            .shortBreak(0.02)
            .longBreakInterval(2)
            .continuous()
            .build();
        Tomatinho tomatinho = new Tomatinho(todo, configuration);

        assertThat(tomatinho.currentTask(), is(equalTo(null)));
        assertThat(tomatinho.status(), is(equalTo(null)));

        tomatinho.start();
        assertThat(tomatinho.currentTask(), is(task1));
        assertThat(tomatinho.status(), is(WORKING));

        Thread.sleep(Math.round(1000 * 0.021));
        assertThat(tomatinho.status(), is(SHORT_BREAK));

        Thread.sleep(Math.round(1000 * 0.021));
        assertThat(tomatinho.status(), is(WORKING));
        assertThat(tomatinho.currentTask(), is(task1));

        task1.finish();
        Thread.sleep(Math.round(1000 * 0.021));
        assertThat(tomatinho.status(), is(LONG_BREAK));

        Thread.sleep(Math.round(1000 * 0.021));
        assertThat(tomatinho.status(), is(WORKING));
        assertThat(tomatinho.currentTask(), is(task2));
    }
}