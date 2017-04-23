package threads;

public class SampleSynchroThread extends Thread {
    private static int valueS = 17;

    public static synchronized void incrementSynchroMethod() {
        for (int i = 0; i < 1000; i++) valueS += 1;
        System.out.println(valueS + " S");
    }

    @Override
    public void run() {
        incrementSynchroMethod();
    }
}
