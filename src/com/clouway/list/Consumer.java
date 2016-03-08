package com.clouway.list;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class Consumer extends Thread {
    private ListOfElements list;

    public Consumer(ListOfElements list) {

        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String element = list.remove();
                System.out.println("Consumer" + " " + element + "is take");
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
