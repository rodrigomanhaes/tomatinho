package tomatinho;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TomatoTest {

    @Test
    public void testCountsTime() throws InterruptedException {
        final String[] result = new String[1];
        RingListener listener = new RingListener() {
            @Override
            public void ring() {
                result[0] = "Ring!!!";
            }
        };
        Tomato tomato = new Tomato(listener);
        tomato.start(3);
        Thread.sleep(1000);
        assertThat(result[0], is(equalTo(null)));
        Thread.sleep(1000);
        assertThat(result[0], is(equalTo(null)));
        Thread.sleep(1000);
        assertThat(result[0], is("Ring!!!"));
    }

}
