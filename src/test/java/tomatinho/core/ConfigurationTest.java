package tomatinho.core;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class ConfigurationTest {

    @Test
    public void definesTimeVariables() {
        Configuration config = Configuration.builder()
            .workTime(25)
            .shortBreak(5)
            .longBreak(20)
            .build();
        assertThat(config.workTime(), is(25.));
        assertThat(config.shortBreak(), is(5.));
        assertThat(config.longBreak(), is(20.));
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
}
