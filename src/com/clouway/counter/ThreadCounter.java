package com.clouway.counter;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class ThreadCounter implements Runnable {
    private final int countTo;
    private int count;

    public ThreadCounter(int countTo) {
        this.countTo = countTo;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "starting!");
        try {
            for (int i = 0; i < countTo && !Thread.currentThread().isInterrupted(); i++) {
                count = i;
                System.out.println(count);

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {}
        System.out.println(count);
    }
}
