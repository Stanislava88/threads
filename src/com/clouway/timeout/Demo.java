package com.clouway.timeout;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        TimeoutHashTable<Object, Object> table = new TimeoutHashTable<Object, Object>(5);//The time is represented in sec.
        table.put(1, "object1");
        Thread.sleep(2000L);

        table.remove(1);
        table.put(1, "Person"); // timer Restart + replace value
        Thread.sleep(12000L);

        Object result1 = table.get(1); // Eq Null
        System.out.println(result1);

        table.put("key", 1234);     // timer Restart
        Thread.sleep(3000L);

        table.get("key");           //timer restart
        Thread.sleep(12000L);
        System.out.println(table.get("key")); //will return value null

        System.out.println(table.remove(12345)); //will return value null
    }
}
