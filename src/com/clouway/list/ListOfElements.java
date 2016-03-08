package com.clouway.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class ListOfElements {
    private int maxCapacity;
    private List<String> list;

    public ListOfElements(int maxCapacity) {

        this.maxCapacity = maxCapacity;
        list = new ArrayList<String>();
    }

    public synchronized void add(String element) throws InterruptedException {
        while (list.size() == maxCapacity) {
            System.out.println("The list is full. Please, wait!");
            wait();
        }
        list.add(element);
        notifyAll();
    }

    public synchronized String remove() throws InterruptedException {
        while (list.isEmpty()) {
            System.out.println("The list is empty. Please, wait!");
            wait();
        }
        String lastElement = list.get(list.size() - 1);
        list.remove(lastElement);
        notifyAll();
        return lastElement;
    }
}
