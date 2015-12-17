package multi.counter;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class Demo {

    public static void main(String[] args) {
        Object lock= new Object();
        MultiCounter controller = new MultiCounter(1, 5, lock);
        MultiCounter controlled = new MultiCounter(1, 10, lock);
        controller.giveControl(controlled);
        controller.start();
        controlled.start();
    }

}
