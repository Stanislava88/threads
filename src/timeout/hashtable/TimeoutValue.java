package timeout.hashtable;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class TimeoutValue {
    private final Object value;
    private long time;

    public <T> TimeoutValue(T value, long time) {
        this.value = value;
        this.time = time;
    }


    public long time() {
        return time;
    }

    public void time(long time) {
        this.time= time;
    }

    public <T> T value() {
        return (T)value;
    }
}
