package threads;

/**
 * Created by Ravskiy Pavel on 20.04.2017.
 */
public class MyThreadCopy extends Thread {

    private int count;
    private String name;

    public MyThreadCopy(int count, String name) {
        this.count = count;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) System.out.println(currentThread().getName() + " - " + name);
    }
}
