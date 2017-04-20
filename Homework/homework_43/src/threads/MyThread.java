package threads;

public class MyThread extends Thread {

    public void printHelloFiveTimes(){ for (int i = 0; i < 5; i++) new MyThread().start();}

    @Override
    public void run() { System.out.println(Thread.currentThread().getName() + " - " + "Hello World");}
}
