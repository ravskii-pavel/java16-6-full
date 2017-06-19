package sender;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        INSTANCE.sendEmail("petrosyan@yopmail.com", "Hello mr Petrosyan", "Very argent");
//        emailSender.sendEmail();

        ArrayBlockingQueue<EmailMessage> queue = new ArrayBlockingQueue<>(10);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        EmailProducer producer = new EmailProducer(queue);

        executorService.execute(new EmailConsumer(queue));
        executorService.execute(new EmailConsumer(queue));
        executorService.execute(new EmailConsumer(queue));


        List<EmailMessage> messageList = Arrays.asList(
                new EmailMessage("vorotnikovanton888@gmail.com", "Hello Kitty", "Hello Kitty"),
                new EmailMessage("dp190792kdg@gmail.com", "Hello Kitty", "home"),
                new EmailMessage("dp190792kdg@gmail.com", "Hello Kitty", "visit"),
                new EmailMessage("dmitrij.kuzmenko@privatbank.ua", "Hello Kitty", "Hello Kitty"),
                new EmailMessage("dmitrij.kuzmenko@privatbank.ua", "Hello Kitty", "home"),
                new EmailMessage("dmitrij.kuzmenko@privatbank.ua", "Hello Kitty", "visit"));

        producer.sendMessage(messageList);




       executorService.shutdown();
    }
}