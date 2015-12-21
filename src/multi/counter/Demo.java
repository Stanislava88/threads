package multi.counter;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class Demo {

    public static void main(String[] args) {
        Counter count = new Counter();
        count.notFirstThread("Thread2");
        MultiCounter controller = new MultiCounter("Thread1" ,1, 5, count);
        MultiCounter controlled = new MultiCounter("Thread2" ,1, 10, count);

        controller.start();
        controller.giveControl(controlled);
        controlled.start();

    }

}
