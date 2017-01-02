package com.trongvn13.counterdown;

import java.util.ArrayList;
import java.util.List;

public class Counter implements TickListener {
    private long count = 0;
    private long period = 0;
    private Ticker ticker = null;
    private List<CounterListener> listeners = null;

    public Counter(long period) {
        this.period = period;
        ticker = new Ticker();
        ticker.addListener(this);
        listeners = new ArrayList<>();
    }

    void addListener(CounterListener listener) {
        if (listener == null)
            return;

        if (!listeners.contains(listener))
            listeners.add(listener);
    }

    protected void count() {
        count--;
        if (count < 1) {
            count = period;
            onTimed();
        }
    }

    public void onTimed() {
        for (CounterListener listener : listeners) {
            listener.onTimed();
        }
    }

    public void start() {
        count = period;
        ticker.start();
    }

    @Override
    public void onTick() {
        count();
    }
}
