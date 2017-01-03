package com.trongvn13.counterdown.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Ticker {
    private List<TickListener> listeners = null;

    public Ticker() {
        listeners = new ArrayList<>();
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
        for (TickListener listener : listeners) {
            listener.onTick();
        }
    }

    public void addListener(TickListener listener) {
        if (listener == null)
            return;

        if (!listeners.contains(listener))
            listeners.add(listener);
    }
}
