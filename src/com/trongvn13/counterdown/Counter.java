package com.trongvn13.counterdown;

public class Counter {
    private long count = 0;
    private long period = 0;
    private Ticker ticker = null;
    private Runnable task = null;
    
    public Counter(Runnable task, long period) {
        this.task = task;
        this.period = period;
        ticker = new Ticker(new Runnable() {
            @Override
            public void run() {
                count();
            }
        });
    }
    
    protected void count() {
        count--;
        if (count < 1) {
            count = period;
            task.run();
        }
    }

    public void start() {
        count = period;
        ticker.start();
    }
}
