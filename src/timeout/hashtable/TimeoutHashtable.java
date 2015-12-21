package timeout.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class TimeoutHashtable<K, T> {

    private K k;
    private T t;


    private ConcurrentHashMap<K, Map<T, Long>> hashtable= new ConcurrentHashMap<>();

    private boolean running=true;

    public TimeoutHashtable(long longTimeoutInSeconds){

        initiate(longTimeoutInSeconds);
    }


    private void initiate(long timeoutSeconds) {
        new Thread(){
            @Override
            public void run(){
                while (running){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    check();
                }
            }

            public void check(){
                for(K key: hashtable.keySet()){
                    Map<T, Long> map= hashtable.get(key);
                    for(T t: map.keySet()){
                        Long currentValue= map.get(t);
                        if (currentValue>= timeoutSeconds){
                            hashtable.remove(key);
                        }else{
                            map.put(t, currentValue+1);
                        }
                    }

                }
            }
        }.start();
    }

    public void shutdown(){
        running=false;
    }

    public synchronized void put(K key, T value){
        Map<T, Long> map= new HashMap<>();
        map.put(value, 0L);
        hashtable.put(key, map);
    }

    public synchronized T get(String key){
        if (hashtable.containsKey(key)) {
            Map<T, Long> map = hashtable.get(key);
            for (T type : map.keySet()) {
                map.put(type, 0L);
                return type;
            }
        }
        return null;
    }

    public synchronized T remove(String key){
        if (hashtable.containsKey(key)) {
            Map<T, Long> map = hashtable.remove(key);
            for (T type : map.keySet()) {
                return type;
            }
        }
            return null;
    }

}
