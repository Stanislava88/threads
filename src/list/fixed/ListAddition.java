package list.fixed;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class ListAddition implements Runnable{
    private FixedList list;

    public ListAddition(FixedList list) {
        this.list = list;
    }


    @Override
    public void run() {
        for(int i=0; i<25; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }

            list.add(new Dog("Dog number: "+i));
            System.out.println(list.printAllElements());
        }
    }
}
