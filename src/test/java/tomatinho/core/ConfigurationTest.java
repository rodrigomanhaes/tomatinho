package tomatinho.core;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class ConfigurationTest {

    @Test
    public void definesTimeVariables() {
        Configuration config = Configuration.builder()
            .workTime(25)
            .shortBreak(5)
            .longBreak(20)
            .longBreakInterval(2)
            .continuous()
            .build();
        assertThat(config.workTime(), is(25.));
        assertThat(config.shortBreak(), is(5.));
        assertThat(config.longBreak(), is(20.));
        assertThat(config.longBreakInterval(), is(2));
        assertThat(config.continuous(), is(true));
    }

    @Test(expected=IllegalArgumentException.class)
    public void requiresWorkTime() {
        Configuration.builder().shortBreak(5).longBreak(20).build();
    }

    @Test(expected=IllegalArgumentException.class)
    public void requiresShortBreak() {
        Configuration.builder().workTime(25).longBreak(20).build();
    }

    @Test(expected=IllegalArgumentException.class)
    public void requiresLongBreak() {
        Configuration.builder().shortBreak(5).workTime(25).build();
    }

    @Test
    public void isNotContinuousByDefault() {
        assertThat(Configuration.builder()
            .workTime(25)
            .shortBreak(5)
            .longBreak(20)
            .longBreakInterval(2)
            .build()
            .continuous(),
            is(false));
    }
}
