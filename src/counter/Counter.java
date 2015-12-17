package counter;

import java.util.Scanner;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class Counter implements Runnable {


    private static int currentValue;
    private int value;

    public Counter(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        try {

            for (int i = 0; i < value; i++) {
                currentValue = i;
                Thread.sleep(100);

            }
        } catch (InterruptedException e) {

        }
        System.out.println("thread stoped");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Counter(1000));
        thread.start();
        Scanner input = new Scanner(System.in);
        input.next();
        thread.interrupt();
        System.out.println(currentValue);

    }
}
