package list.fixed;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class Demo {
    public static void main(String[] args) {
        FixedList list= new FixedList(12);
        ListRemover remover= new ListRemover(list);
        ListDogAddition addition= new ListDogAddition(list);
        Thread removerThread= new Thread(remover);
        Thread additionThread= new Thread(addition);

        list.add(new Dog("123"));
        additionThread.start();
        removerThread.start();
    }
}
