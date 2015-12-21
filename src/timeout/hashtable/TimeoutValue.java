package timeout.hashtable;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class TimeoutValue<T> {
    private final T value;
    private long time;

    public  TimeoutValue(T value, long time) {
        this.value = value;
        this.time = time;
    }


    public long time() {
        return time;
    }

    public void time(long time) {
        this.time= time;
    }

    public T value() {
        return value;
    }
}
