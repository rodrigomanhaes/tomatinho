package tomatinho.core;

public class Configuration {
    private Double workTime, shortBreak, longBreak;
    private Integer longBreakInterval;
    private boolean continuous;
    
    private Configuration() {
        this.continuous = false;
    }
    
    public static Builder builder() {
        return new Builder(new Configuration());
    }
    
    public static class Builder {
        private Configuration config;
        
        private Builder(Configuration config) {
            this.config = config;
        }
        
        public Builder workTime(double workTime) {
            config.workTime = workTime;
            return this;
        }
        
        public Builder shortBreak(double shortBreak) {
            config.shortBreak = shortBreak;
            return this;
        }
        
        public Builder longBreak(double longBreak) {
            config.longBreak = longBreak;
            return this;
        }
        
        public Builder longBreakInterval(int longBreakInterval) {
            config.longBreakInterval = longBreakInterval;
            return this;
        }
        
        public Builder continuous() {
            config.continuous = true;
            return this;
        }
        
        public Configuration build() {
            return config.validate();
        }
    }
    
    public Double workTime() {
        return workTime;
    }
    
    public Double longBreak() {
        return longBreak;
    }
    
    public Double shortBreak() {
        return shortBreak;
    }
    
    public Integer longBreakInterval() {
        return longBreakInterval;
    }
    
    public boolean continuous() {
        return continuous;
    }
    
    private Configuration validate() {
        if (workTime == null || shortBreak == null || longBreak == null)
            throw new IllegalArgumentException(
                "workTime, shortBreak and longBreak are required");
        return this;
    }
}
