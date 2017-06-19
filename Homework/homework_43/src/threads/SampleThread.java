package threads;

public class SampleThread extends Thread {
    private static int value = 417;

    private void incrementMethod() {
        for (int i = 0; i < 1000; i++) value += 1;
        System.out.println(value);
    }
    @Override
    public void run() {incrementMethod();}
}
