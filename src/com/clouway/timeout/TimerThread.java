package com.clouway.timeout;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class TimerThread<K, T> extends Thread {
    private TimeoutHashTable<K, T> table;
    private final K key;
    private T value;

    private long timeout;
    private long currentTime;

    public TimerThread(TimeoutHashTable<K, T> table, K key, T value, long timeout) {
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
            T removedValue = table.remove(key);
            System.out.println("The value: " + removedValue + " is removed!");
        } catch (InterruptedException e) {
            return;
        }
    }

    public void restartTimer() {
        this.currentTime = timeout;
    }

    public void replace(T newValue) {
        this.value = newValue;
    }

    public T getValue() {
        return value;
    }
}
