package com.clouway.counter;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class ThreadCounter implements Runnable {
    private int countTo;
    private int count;

    public ThreadCounter(int countTo) {
        this.countTo = countTo;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "starting!");
        try {
            do {
                Thread.sleep(100);
                count++;
            } while (count < countTo && !Thread.currentThread().isInterrupted());
        } catch (InterruptedException e) {
        }
        System.out.println(count);
    }
}
