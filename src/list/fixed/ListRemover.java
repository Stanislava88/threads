package list.fixed;


/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class ListRemover implements Runnable {
    private FixedList list;

    public ListRemover(FixedList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for(int i=0; i<25; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }

            list.remove();
            System.out.println(list.printAllElements());
        }
    }
}
