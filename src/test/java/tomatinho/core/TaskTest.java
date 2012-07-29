package tomatinho.core;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
    public void canBeMarkedAsFinished() {
        Task task = new Task("dummy");
        task.markAsFinished();
        assertThat(task.finished(), is(true));
    }
}
