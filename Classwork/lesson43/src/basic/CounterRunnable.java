package basic;

import static basic.Main.print;

/**
 * Created by java on 14.04.2017.
 */
public class CounterRunnable implements Runnable {
    private int initialValue;
    private int step;
    private int maxValue;

    public CounterRunnable(int initialValue, int step, int maxValue) {
        this.initialValue = initialValue;
        this.step = step;
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        for(int i = initialValue; i < maxValue; i += step){
            print(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
