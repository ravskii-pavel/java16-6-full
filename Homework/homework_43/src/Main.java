import threads.MyThread;
import threads.MyThreadCopy;

public class Main {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " - hhhhhh");
       /*1) Создайте класс потока, который выводит в консоль «Hello world».*/
        System.out.print("Task 1: ");
        new MyThread().start();

       /* 2) В отдельном методе, создайте 5-ть экземпляров описанного класса, для того чтобы вывести в консоль
        надпись «Hello world» 5-ть раз, каждый раз из нового потока. Для того чтобы было понятно какой
        именно поток выводит строку в консоль, можно добавить в вывод имя потока.*/

        MyThread myThread2 = new MyThread();
        myThread2.printHelloFiveTimes();

        /*3) По аналогии с описанным классом создайте новый класс, который будет выводить указанную надпись
        в консоль, определенное количество раз. Сама надпись и количество повторений необходимо
        передавать в конструкторе.*/

        MyThreadCopy myThreadCopy = new MyThreadCopy(8, "Bob");
        myThreadCopy.testManyThreads();
        //myThreadCopy.start();

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
