import threads.MyThread;

public class Main {

    public static void main(String[] args) {
        /*MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        myThread.start();
        myThread1.start();*/

        MyThread myThread3 = new MyThread();
        myThread3.printHelloNew(7);
        myThread3.start();
        //printHello(5);


      /*  Thread thread = new Thread(){
            @Override
            public void run(){
                System.out.println(Thread.currentThread().getName());
                for(int i =0; i< 10; i++){
                    System.out.println(Thread.currentThread().getName() + " p" + i);
                }
            }
        };
        thread.start();

       for(int i =0; i< 10; i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }*/
    }
    public static void printHello(int count){

        for (int i = 0; i < count; i++){
            new MyThread().start();
        }

    }
}
