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

    @Test
    public void canBeInterrupted() {
        Tomato tomato = new Tomato();
        tomato.externalInterruption();
        tomato.externalInterruption();
        tomato.internalInterruption();
        tomato.externalInterruption();
        tomato.internalInterruption();
        assertThat(tomato.interruptionCount(), is(5));
        assertThat(tomato.externalInterruptionCount(), is(3));
        assertThat(tomato.internalInterruptionCount(), is(2));
    }
}