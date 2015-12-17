package multi.counter;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class Demo {

    public static void main(String[] args) {
        KeyLock lock = new KeyLock();
        MultiCounter controller = new MultiCounter("Thread1" ,1, 5, lock);
        MultiCounter controlled = new MultiCounter("Thread2" ,1, 10, lock);
        controller.giveControl(controlled);
        controller.start();
        controlled.start();

    }

}
