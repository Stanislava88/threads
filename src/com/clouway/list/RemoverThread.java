package com.clouway.list;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class RemoverThread extends Thread {
    private ListOfElements list;

    public RemoverThread(ListOfElements list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String element = list.remove();
                System.out.println("RemoverThread:" + element + " is removed.");

                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
