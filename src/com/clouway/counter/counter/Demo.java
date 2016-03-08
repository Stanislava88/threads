package com.clouway.counter.counter;

import java.util.Scanner;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ThreadCounter counter = new ThreadCounter(50);

        Thread thread = new Thread(counter);
        thread.start();

        if (scanner.hasNext()) {
            thread.interrupt();
        }
    }
}
