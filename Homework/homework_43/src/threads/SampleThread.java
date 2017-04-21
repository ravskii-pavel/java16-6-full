package threads;

public class SampleThread extends Thread {

    @Override
    public void run() {
        Main.incrementMethod();
    }
}
