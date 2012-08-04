package tomatinho.core;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Date;

import org.junit.Test;

public class TaskTest {

    @Test
    public void hasADescription() {
        assertThat(
                new Task("A smart description").description(),
                is("A smart description"));
    }

    @Test
    public void initiallyIsntFinished() {
        assertThat(new Task("dummy").finished(), is(false));
    }

    @Test
    public void canBeFinished() {
        Task task = new Task("dummy");
        task.finish();
        assertThat(task.finished(), is(true));
    }

    @Test
    public void hasStartTimeNotesAndType() {
        Task task = new Task("dummy");
        Date thisDate = new Date();
        task
            .startTime(thisDate)
            .notes("something relevant about task")
            .type("Studying");
        assertThat(task.startTime(), is(thisDate));
        assertThat(task.notes(), is("something relevant about task"));
        assertThat(task.type(), is("Studying"));
    }

    @Test
    public void startsAndEndsTomato() {
        Task task = new Task("dummy");
        assertThat(task.currentTomato(), is(equalTo(null)));
        assertThat(task.tomatoCount(), is(0));
        task.startTomato();
        assertThat(task.tomatoCount(), is(0));
        assertThat(task.currentTomato(), is(instanceOf(Tomato.class)));
        task.finishTomato();
        assertThat(task.currentTomato(), is(equalTo(null)));
        assertThat(task.tomatoCount(), is(1));
    }
}