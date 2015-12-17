package timeouthashtable;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class TimeoutHashTable<K, V> {

    private Map<K, TimeoutRemover<K, V>> timeoutHashTable = new Hashtable<>();
    private long timeout;
    private TimeoutRemover<K,V> thread;

    public TimeoutHashTable(long timeout) {
        this.timeout = timeout;
    }

    public void put(K key, V value) {
        if (timeoutHashTable.containsKey(key)) {
            timeoutHashTable.get(key);
            thread.resetCounter();

            return;
        }
        thread = new TimeoutRemover<>(timeoutHashTable, key, value, timeout);
        timeoutHashTable.put(key, thread);
        thread.start();
    }

    public V get(K key) {
        if (!timeoutHashTable.containsKey(key)) {
            return null;
        } else {
            thread.resetCounter();

            return timeoutHashTable.get(key).getValue();
        }
    }

    public V remove(K key) {
        if (!timeoutHashTable.containsKey(key)) {
            return null;
        }
        return timeoutHashTable.remove(key).getValue();

    }

    public void printAllElements() {

        Iterator it = timeoutHashTable.entrySet().iterator();

        while (it.hasNext()) {

            Map.Entry pair = (Map.Entry) it.next();

            TimeoutRemover timeoutRemover = (TimeoutRemover) pair.getValue();
            System.out.println(pair.getKey() + " --> " + timeoutRemover.getValue());

        }
    }

}
