package list.fixed;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class FixedList {

    private Object[] list=null;
    private int currentIndex=0;

    public FixedList(int length){
        list=new Object[length];
    }


    public synchronized void add(Object obj) {
        if (currentIndex<list.length) {
            list[currentIndex] = obj;
            currentIndex++;
            notifyAll();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void remove() {
        if (currentIndex>=1) {
            list[currentIndex - 1] = null;
            currentIndex--;
            notifyAll();
        }
        else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized String printAllElements(){
        String printable="";
        for (Object aList : list) {
            if(!(aList==null)) {
                printable += System.getProperty("line.separator") + aList.toString();
            }else{
                break;
            }
        }
        return printable;

    }


}
