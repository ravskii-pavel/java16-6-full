package threads;

public class SampleSynchroThread extends Thread {

    @Override
    public void run() {
        Main.incrementSynchroMethod();
    }
}
