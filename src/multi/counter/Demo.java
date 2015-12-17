package multi.counter;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class Demo {

    public static void main(String[] args) {
        MultiCounter controller = new MultiCounter(1, 5);
        MultiCounter controlled = new MultiCounter(1, 10);
        controller.giveControl(controlled);
        controller.start();
        controlled.start();
    }

}
