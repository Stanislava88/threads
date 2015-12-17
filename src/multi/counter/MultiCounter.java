package multi.counter;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class MultiCounter extends Thread {

    private int beginning;
    private int end;
    private Thread thread;
    private final Object lock;


    public MultiCounter(int beginning, int end, Object lock) {
        this.beginning = beginning;
        this.end = end;
        this.lock = lock;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        count();
        if (!(thread==null)) {
            thread.interrupt();
        }


    }

    public void count() {
        String name = Thread.currentThread().getName();

        while(beginning<=end) {

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
            System.out.println(name + ": " + beginning);
            synchronized (lock){
                beginning++;
            }
        }


    }

    public void giveControl(Thread thread) {
        this.thread = thread;
    }
}
