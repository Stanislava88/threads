package multi.counter;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class MultiCounter extends Thread {

    private int beginning;
    private int end;
    private Thread thread;

    public MultiCounter(int beginning, int end) {
        this.beginning = beginning;
        this.end = end;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        count();
        System.out.println(name + " stoped");
        if (!(thread==null)) {
            thread.interrupt();
        }
    }

    public void count() {
        String name = Thread.currentThread().getName();
        for (int i = beginning; i <= end; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
            System.out.println(name + ": " + i);

        }
    }

    public void giveControl(Thread thread) {
        this.thread = thread;
    }
}
