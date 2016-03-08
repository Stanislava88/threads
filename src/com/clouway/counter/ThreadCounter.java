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
        if (!Thread.currentThread().isInterrupted()) {
            try {
                for (int i = 0; i < countTo; i++) {
                    count = i;
                    System.out.println(count);

                    Thread.sleep(1000L);
                }
            } catch (InterruptedException e) {
            }
            System.out.println(count);
        }
    }
}