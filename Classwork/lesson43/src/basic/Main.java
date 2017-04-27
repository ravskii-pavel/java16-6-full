package basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        /* Thread thread = new Thread(){
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
        }
    }*/

 /*       basic.CounterThread thread1 = new basic.CounterThread(1, 1, 17);
        basic.CounterThread thread2 = new basic.CounterThread(0, 5, 26);

        thread1.setName("New Counter Thread");

        thread1.start();
        thread2.start();*/
        /*Thread t1 = new Thread(new basic.CounterRunnable(1, 2, 13));
        Thread t2 = new Thread(new basic.CounterRunnable(17, 10, 99));
        //Thread t2 = new Thread(new basic.CounterRunnable(17, 10, 99));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        t1.start();
        t2.start();*/




        //Thread t2 = new Thread(new basic.CounterRunnable(17, 10, 99));

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        /*executorService.execute(new basic.CounterRunnable(1, 2, 13));
        executorService.execute(new basic.CounterRunnable(17, 10, 99));
        executorService.execute(new basic.CounterRunnable(4, 3, 47));
        executorService.execute(new basic.CounterRunnable(4, 3, 47));
        //executorService.execute(new basic.CounterRunnable(1, 2, 13));
        executorService.execute(() -> System.out.println("Hello!!!"));*/

        executorService.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                Thread thread = new Thread(new CounterRunnable(1, 2, 1000));
                thread.start();

                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " finished");
            }
        });
        System.out.println(Thread.currentThread().getName() + " finished");

        executorService.shutdown();

    }

    public static synchronized void print(String text){
        System.out.println(text);
    }
}
