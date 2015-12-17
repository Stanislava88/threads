package multi.counter;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class MultiCounter extends Thread {

    private int beginning;
    private int end;
    private Thread thread;
    private final KeyLock keyLock;


    public MultiCounter(int beginning, int end, KeyLock keyLock) {
        this.beginning = beginning;
        this.end = end;
        this.keyLock = keyLock;
    }

    @Override
    public void run() {
        count();
        if (!(thread == null)) {
            thread.interrupt();
        }


    }

    public void count() {
        String name = Thread.currentThread().getName();


        for (int i = beginning; i <= end; i++) {
            try{
                sleep(100);
            }catch (InterruptedException ex){
                break;
            }
                keyLock.lastThread(name);
                System.out.println(name+": "+i);


        }
    }

    public void giveControl(Thread thread) {
        this.thread = thread;
    }
}
