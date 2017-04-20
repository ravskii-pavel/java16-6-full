package threads;

/**
 * Created by Ravskiy Pavel on 20.04.2017.
 */
public class MyThreadCopy extends Thread {

    private int count;
    private String name;

    private MyThreadCopy(String name) {
        this.name = name;
    }

    public MyThreadCopy(int count, String name) {
        this.count = count;
        this.name = name;
        //this.printNameManyTimes(count,name);
    }

    public void printNameManyTimes(int count, String name){for (int i = 0; i < count; i++) new MyThreadCopy(name).start();}
    public void testManyThreads (){
        printNameManyTimes(7, "Harry");
        printNameManyTimes(9, "Pit");
        printNameManyTimes(2, "Cooper");
    }

    @Override
    public void run() {System.out.println(currentThread().getName() + " - " + name);}
}
