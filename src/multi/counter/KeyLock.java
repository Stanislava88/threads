package multi.counter;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class KeyLock {

    private String name="";

    public synchronized void lastThread(String name) {
        while(this.name.equals(name)){
            try {
                wait();
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
        this.name = name;
        notifyAll();
    }
}
