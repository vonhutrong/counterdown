package com.trongvn13.counterdown;

import java.util.Timer;
import java.util.TimerTask;

public class Ticker {
    private Runnable task = null;
    
    public Ticker(Runnable task) {
        this.task = task;
    }
    
    public void start() {
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                onTick();
            }
        }, 0, 1000);
    }

    protected void onTick() {
        task.run();
    }
}
