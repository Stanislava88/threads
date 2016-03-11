package com.clouway.timeout;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class TimeoutHashTable<K, T> {
    private final Map<K, TimerThread<K, T>> table = new Hashtable<K, TimerThread<K, T>>();

    private final long timeout;

    public TimeoutHashTable(long timeout) {
        this.timeout = timeout;
    }

    public void put(K key, T value) {
        if (!table.containsKey(key)) {
            TimerThread<K, T> timer = new TimerThread<K, T>(table, key, value, timeout);

            table.put(key, timer);

            timer.start();
        } else {
            TimerThread<K, T> timer = table.get(key);

            timer.replace(value);

            timer.restart();
        }
    }

    public T remove(K key) {
        if (table.containsKey(key)) {
            TimerThread<K, T> timer = table.get(key);
            T value = timer.getValue();
            timer.interrupt();
            table.remove(key);

            return value;
        }
        return null;
    }

    public T get(K key) {
        if (table.containsKey(key)) {
            TimerThread<K, T> timer = table.get(key);
            timer.restart();

            return timer.getValue();
        }
        return null;
    }
}
