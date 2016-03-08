package com.clouway.counters;


/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class Demo {
    public static void main(String[] args) {
        ThreadCounter counter1 = new ThreadCounter(1, 5);
        ThreadCounter counter2 = new ThreadCounter(1, 5000);

        counter2.observeThread(counter1);
        counter1.observeThread(counter2);

        counter1.start();
        counter2.start();
    }
}

