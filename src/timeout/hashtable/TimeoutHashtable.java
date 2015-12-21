package timeout.hashtable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class TimeoutHashtable<K, T> {

    private ConcurrentHashMap<K, TimeoutValue> hashtable= new ConcurrentHashMap<>();

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
                    TimeoutValue value= hashtable.get(key);
                    long time= value.time();
                    if (time>=timeoutSeconds){
                        hashtable.remove(key);
                    }else{
                        value.time(time+1);
                    }

                }
            }
        }.start();
    }

    public void shutdown(){
        running=false;
    }

    public synchronized void put(K key, T value){
        hashtable.put(key, new TimeoutValue(value, 0L));
    }

    public synchronized T get(K  key){
        if (hashtable.containsKey(key)) {
            return hashtable.get(key).value();
        }
        return null;
    }

    public synchronized T remove(K key){
        if (hashtable.containsKey(key)) {
            TimeoutValue tv = hashtable.remove(key);
            return tv.value();
        }
        return null;
    }

}
