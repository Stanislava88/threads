package com.clouway.list;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class Producer extends Thread {
    private ListOfElements list;

    public Producer(ListOfElements list) {

        this.list = list;
    }

    @Override
    public void run() {
        String[] elements = {"one", "two", "three", "four", "five"};
        for (String each : elements) {
            try {
                list.add(each);
                System.out.println("Producer:" + " " + each + "is added");
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
