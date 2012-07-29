package tomatinho.core;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import static tomatinho.core.Status.*;

public class StatusTest {

    @Test
    public void controlsStatusFlow() {
        FlowController flow = newFlowController(
            Configuration.builder()
                .shortBreak(1) // dummy
                .longBreak(2) // dummy
                .workTime(1) // dummy
                .longBreakInterval(3) // relevant!!
                .build()
        );
        assertFlow(flow, 
            WORKING, WAITING, SHORT_BREAK,
            WAITING, WORKING, WAITING, SHORT_BREAK,
            WAITING, WORKING, WAITING, LONG_BREAK,
            WAITING, WORKING, WAITING, SHORT_BREAK);
    }
    
    @Test
    public void controlsContinuousStatusFlow() {
        FlowController flow = newFlowController(
            Configuration.builder()
                .shortBreak(1) // dummy
                .longBreak(2) // dummy
                .workTime(1) // dummy
                .longBreakInterval(4) // relevant!!
                .continuous() // relevant!!
                .build()
        );
        
        assertFlow(flow, 
            WORKING, SHORT_BREAK, WORKING, SHORT_BREAK, 
            WORKING, SHORT_BREAK, WORKING, LONG_BREAK,
            WORKING, SHORT_BREAK, WORKING, SHORT_BREAK, 
            WORKING, SHORT_BREAK, WORKING, LONG_BREAK);
    }
    
    private void assertFlow(FlowController flow, Status... statuses) {
        for (Status status: statuses) {
            assertThat(flow.next(), is(status));
            assertThat(flow.current(), is(status));
        }
    }

}
