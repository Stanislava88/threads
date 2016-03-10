package com.clouway.timeout;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class TimeoutHashTable<K, T> {
    private Map<K, TimerThread<K, T>> table = new Hashtable<K, TimerThread<K, T>>();

    private long timeout;

    public TimeoutHashTable(long timeout) {
        this.timeout = timeout;
    }

    public void put(K key, T value) {
        if (!table.containsKey(key)) {
            TimerThread<K, T> timer = new TimerThread<K, T>(this, key, value, timeout);

            table.put(key, timer);

            timer.start();
        } else {
            TimerThread<K, T> timer = table.get(key);

            timer.replace(value);

            timer.restartTimer();
        }
    }

    public T remove(K key) {
        if (table.containsKey(key)) {
            TimerThread<K, T> timer = table.get(key);
            T value = timer.getValue();

            table.remove(key);
            return value;
        }
        return null;
    }

    public T get(K key) {
        if (table.containsKey(key)) {

            TimerThread<K, T> timer = table.get(key);
            timer.restartTimer();
            return timer.getValue();
        }
        return null;
    }
}
