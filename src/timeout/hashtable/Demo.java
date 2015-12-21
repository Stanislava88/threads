package timeout.hashtable;
/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class Demo {

    public static void main(String[] args) {
        TimeoutHashtable<String, String> timeTable= new TimeoutHashtable<>(1);
        timeTable.put("key1", "value1");
        timeTable.put("key2", "value2");
        timeTable.put("key3", "value3");
        System.out.println(timeTable.remove("key3"));
        System.out.println(timeTable.get("key2"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timeTable.put("key4", "value4");
        System.out.println(timeTable.get("key4"));
        System.out.println(timeTable.get("key2"));

        try{
            Thread.sleep(3000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println(timeTable.get("key4"));
        timeTable.shutdown();
    }
}
