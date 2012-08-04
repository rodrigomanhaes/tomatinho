package tomatinho.core;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class TomatoTest {

    @Test
    public void startsUnfinished() {
        assertThat(new Tomato().finished(), is(false));
    }

    @Test
    public void canBeFinished() {
        Tomato tomato = new Tomato();
        tomato.finish();
        assertThat(tomato.finished(), is(true));
    }
}
