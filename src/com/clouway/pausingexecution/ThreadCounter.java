package com.clouway.pausingexecution;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class ThreadCounter extends Thread {
    private final int from;
    private final int to;
    private ThreadCounter thread;

    public ThreadCounter(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        try {
            for (int i = from; i <= to && !isInterrupted(); i++) {
                System.out.println(getName() + "->" + i);

                Thread.sleep(1000L);

                if (i == to) {
                    thread.interrupt();
                }
            }
        } catch (InterruptedException ex) {
            System.out.println(getName() + "interrupted");
        }
    }

    public void observeThread(ThreadCounter thread) {
        this.thread = thread;
    }
}
