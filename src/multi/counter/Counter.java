package multi.counter;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class Counter {

    private String lastThread;



    public synchronized void count(int start, int end, String threadName) {
        for (int i = start; i <= end; i++) {
            while (this.lastThread.equals(threadName)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
            System.out.println(threadName + ": " + i);
            this.lastThread = threadName;
            notifyAll();
        }
    }

    public void notFirstThread(String notFirstThread) {
        lastThread=notFirstThread;
    }
}
