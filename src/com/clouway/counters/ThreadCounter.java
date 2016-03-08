package com.clouway.counters;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class ThreadCounter extends Thread {
    private final int from;
    private final int to;

    private ThreadCounter thread;

    public ThreadCounter(int countFrom, int countTo) {
        this.from = countFrom;
        this.to = countTo;
    }

    @Override
    public void run() {
        for (int i = from; i <= to; i++) {
            if (!isInterrupted()) {
                System.out.println(getName() + "-" + i);
                if (i == to) {
                    thread.interrupt();
                }
            }
        }
    }

    public void observeThread(ThreadCounter thread) {
        this.thread = thread;
    }
}
