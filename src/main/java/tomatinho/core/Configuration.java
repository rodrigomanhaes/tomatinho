package tomatinho.core;

public class Configuration {
    private Integer workTime, shortBreak, longBreak;
    
    private Configuration() {
    }
    
    public static Builder builder() {
        return new Builder(new Configuration());
    }
    
    public static class Builder {
        private Configuration config;
        
        private Builder(Configuration config) {
            this.config = config;
        }
        
        public Builder workTime(int workTime) {
            config.workTime = workTime;
            return this;
        }
        
        public Builder shortBreak(int shortBreak) {
            config.shortBreak = shortBreak;
            return this;
        }
        
        public Builder longBreak(int longBreak) {
            config.longBreak = longBreak;
            return this;
        }
        
        public Configuration build() {
            return config.validate();
        }
    }
    
    public Integer workTime() {
        return workTime;
    }
    
    public Integer longBreak() {
        return longBreak;
    }
    
    public Integer shortBreak() {
        return shortBreak;
    }
    
    private Configuration validate() {
        if (workTime == null || shortBreak == null || longBreak == null)
            throw new IllegalArgumentException(
                "workTime, shortBreak and longBreak are required");
        return this;
    }
}
