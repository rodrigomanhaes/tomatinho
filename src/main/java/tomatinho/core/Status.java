package tomatinho.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Status {
    WORKING, LONG_BREAK, SHORT_BREAK, WAITING;

    public static class FlowController {
        protected Status current;
        private Configuration config;
        private List<Status> sequence;
        private int sequenceIndex;
        
        private FlowController(Configuration config) {
            this.config = config;
            this.current = null;
            this.sequence = new ArrayList<Status>();
            this.sequenceIndex = 0;
            this.buildSequence();
        }

        public Status current() {
            return current;
        }

        public Status next() {
            if (current == null)
                current = WORKING;
            else if (current != WAITING && !config.continuous()) {
                current = WAITING;
            }
            else {
                sequenceIndex = sequenceIndex == sequence().size() - 1 ? 
                    0 : sequenceIndex + 1;
                current = sequence().get(sequenceIndex);
            }
            return current;
        }
        
        private void buildSequence() {
            for (int i = 0; i < config.longBreakInterval() - 1; i++) {
                sequence.add(WORKING);
                sequence.add(SHORT_BREAK);
            }
            sequence.add(WORKING);
            sequence.add(LONG_BREAK);
            sequence = Collections.unmodifiableList(sequence);
        }
        
        protected List<Status> sequence() {
            return sequence;
        }
    }

    public static FlowController newFlowController(Configuration config) {
        return new FlowController(config);
    }
}
