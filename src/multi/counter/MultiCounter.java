package multi.counter;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class MultiCounter extends Thread {

    private String name;
    private int beginning;
    private int end;
    private Thread thread;
    private final KeyLock keyLock;


    public MultiCounter(String name, int beginning, int end, KeyLock keyLock) {
        this.name = name;
        this.beginning = beginning;
        this.end = end;
        this.keyLock = keyLock;
    }

    @Override
    public void run() {


        for (int i = beginning; i <= end; i++) {
            try{
                sleep(100);
            }catch (InterruptedException ex){
                break;
            }
            System.out.println(name + ": " + i);
            keyLock.lastThread(name);
        }

        if (!(thread == null)) {
            thread.interrupt();
        }
    }


    public void giveControl(Thread thread) {
        this.thread = thread;
    }
}
