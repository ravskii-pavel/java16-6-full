package threads;

import threads.MyThread;
import threads.MyThreadCopy;

public class Main {
    static int value = 17;
    static int valueS = 923;
    public static void main(String[] args) {

        System.out.println("Главный поток " + Thread.currentThread().getName() + " - стартовал.");
       /*1) Создайте класс потока, который выводит в консоль «Hello world».*/

       /* new MyThread(){
            @Override
            public void run(){System.out.println("Hello World");}
        }.start();*/

       /* 2) В отдельном методе, создайте 5-ть экземпляров описанного класса, для того чтобы вывести в консоль
        надпись «Hello world» 5-ть раз, каждый раз из нового потока. Для того чтобы было понятно какой
        именно поток выводит строку в консоль, можно добавить в вывод имя потока.*/

       /* printHelloFiveTimes();*/

        /*3) По аналогии с описанным классом создайте новый класс, который будет выводить указанную надпись
        в консоль, определенное количество раз. Сама надпись и количество повторений необходимо
        передавать в конструкторе.*/

       /* new MyThreadCopy(8, "Bob").start();*/

        /* 4) В отдельном методе, создайте несколько экземпляров описанного класса с разными надписями и количеством
        повторений, и запустите их, для того чтобы убедится, что программа отрабатывает корректно.*/

       /* testManyThreads();*/

        /* 5) В отдельном методе, создайте программу, которая запускает поток с множественным выводом строки в консоль,
        и после запуска этого потока выполните присоединение его к основному потоку (thread.join()).*/
        //System.out.println(Thread.currentThread().getName());
        //testJoinMethod();

        /*6) В отдельном методе объявите числовую переменную и создайте два потока, которые должны, без синхронизации,
        в цикле,  инкрементировать ее значение 1000 раз, при этом выводить в консоль только конечный результат.*/
        new SampleThread().start();
        new SampleThread().start();

        /* 7) Теперь добавьте в предыдущий метод синхронизацию таким образом, чтобы в результате инкремента указанного
        числа операция выполнялась атомарно. Например, заданное число 17, после того как один поток отработает число
        должно изменится на 1017, после второго - 2017.*/
        try {
            Thread.sleep(700L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new SampleSynchroThread().start();
        new SampleSynchroThread().start();

    }

    public static void printHelloFiveTimes(){ for (int i = 0; i < 5; i++) new MyThread().start();}

    public static void testManyThreads (){
        new MyThreadCopy(7, "Harry").start();
        new MyThreadCopy(9, "Pit").start();
        new MyThreadCopy(2, "Cooper").start();
    }

    public static void outputLine() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
    public static void testJoinMethod(){
        Thread thread1 = new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 10; i++) {
                    System.out.println("line - " + i);
                }
                System.out.println(Thread.currentThread().getName() + " - завершен");
            }
        };
        thread1.setName("Thread-Join");
        thread1.start();
        System.out.println(thread1.getName() + " - присоеденился.  " + Thread.currentThread().getName()
                + " - приостановлен, ждет пока " + thread1.getName() + " завершится.");
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Главный поток " + Thread.currentThread().getName() + " - завершен.");
    }

    public static void incrementMethod() {
        for (int i = 0; i < 1000; i++) value += 1;
        System.out.println(value);
    }
    public static synchronized void incrementSynchroMethod() {
        for (int i = 0; i < 1000; i++) valueS += 1;
        System.out.println(valueS);
    }
}
