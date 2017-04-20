package threads;

public class MyThread extends Thread {

    /*String name;

    public MyThread() {
        this.name = "Hello World";
    }*/
    public void printHelloNew(int count){
        for (int i = 0; i < count; i++){
            new MyThread().start();
        }
    }

    @Override
    public void run() {
        /*for (int i = 0; i < 10; i++){
            //System.out.println(Thread.currentThread().getName() + " " + i);*/
            System.out.println(Thread.currentThread().getName() + " " + "Hello World");
        //}
    }
}
