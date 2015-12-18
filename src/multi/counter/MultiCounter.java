package multi.counter;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class MultiCounter extends Thread {

    private String name;
    private int beginning;
    private int end;
    private Thread thread;
    private final Counter counter;


    public MultiCounter(String name, int beginning, int end, Counter counter) {
        this.name = name;
        this.beginning = beginning;
        this.end = end;
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.count(beginning, end, name);


        if (!(thread==null)){
            thread.interrupt();
        }
    }


    public void giveControl(Thread thread) {
        this.thread = thread;
    }
}
