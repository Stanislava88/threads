package timeout.hashtable;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class TimeoutHashtable {


    private ConcurrentHashMap<String, Object> hashtable= new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Long> timeoutTable= new ConcurrentHashMap<>();
    private boolean running=true;

    public TimeoutHashtable(long seconds){

        initiate(seconds);
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
                    for(String key: timeoutTable.keySet()){
                        long timeout=timeoutTable.get(key);
                        if(timeout>= timeoutSeconds){
                            timeoutTable.remove(key);
                            hashtable.remove(key);
                        }else{
                            timeoutTable.put(key, timeout+1);
                        }
                    }
                }
            }
        }.start();
    }

    public void shutdown(){
        running=false;
    }

    public synchronized void put(String key, Object value){
        hashtable.put(key, value);
        timeoutTable.put(key, 0L);
    }

    public synchronized Object get(String key){
            return hashtable.get(key);

    }

    public synchronized Object remove(String key){
            return hashtable.remove(key);
    }

}
