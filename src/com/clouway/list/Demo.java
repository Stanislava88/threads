package com.clouway.list;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class Demo {
    public static void main(String[] args) {
        ListOfElements list = new ListOfElements(3);

        AdderThread adder = new AdderThread(list);
        RemoverThread remover = new RemoverThread(list);

        adder.start();
        remover.start();
    }
}
