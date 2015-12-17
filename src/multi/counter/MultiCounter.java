package multi.counter;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class MultiCounter extends Thread {

    private int beginning;
    private int end;
    private Thread thread;
    private boolean flag;

    public MultiCounter(int beginning, int end) {
        this.beginning = beginning;
        this.end = end;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        count();
        System.out.println(name + " stoped");
        if (flag) {
            thread.interrupt();
        }
    }

    public void count() {
        String name = Thread.currentThread().getName();
        try {
            for (int i = beginning; i <= end; i++) {
                Thread.sleep(1000);
                System.out.println(name + ": " + i);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted");
        }
    }

    public void giveControl(Thread thread) {
        this.flag = true;
        this.thread = thread;
    }
}
