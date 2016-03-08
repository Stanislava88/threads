package com.clouway.list;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class Demo {
    public static void main(String[] args) {
        ListOfElements list = new ListOfElements(2);

        Producer producer = new Producer(list);
        Consumer consumer = new Consumer(list);

        Producer producer1 = new Producer(list);

        producer.start();
        producer1.start();
        consumer.start();
    }
}
