package tomatinho.core;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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
}
