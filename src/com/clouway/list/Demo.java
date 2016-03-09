package com.clouway.list;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class Demo {
    public static void main(String[] args) {
        ListOfElements list = new ListOfElements(3);

        AdderThread producer = new AdderThread(list);
        RemoverThread consumer = new RemoverThread(list);

        producer.start();
        consumer.start();
    }
}
