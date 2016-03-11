package com.clouway.timeout;

import java.util.Map;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class TimerThread<K, T> extends Thread {
    private final Map<K, TimerThread<K, T>> table;
    private final K key;
    private T value;

    private final long timeout;
    private long currentTime;

    public TimerThread(Map<K, TimerThread<K, T>> table, K key, T value, long timeout) {
        this.table = table;
        this.key = key;
        this.value = value;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        try {
            currentTime = timeout;
            while (currentTime > 0) {
                System.out.println("The time live for value: " + value + " is " + currentTime);

                currentTime--;

                Thread.sleep(1000L);
            }
            table.remove(key);
            System.out.println("The value:" + value + " removed!");
        } catch (InterruptedException e) {
            System.out.println("I was interrupted on " + currentTime + " second.The element " + value + " is removed");
            return;
        }
    }

    public void restart() {
        this.currentTime = timeout;
    }

    public void replace(T newValue) {
        this.value = newValue;
    }

    public T getValue() {
        return value;
    }
}
