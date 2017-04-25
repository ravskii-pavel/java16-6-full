package sender;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by java on 21.04.2017.
 */
public class EmailProducer {

    private final ArrayBlockingQueue<EmailMessage> queue;

    public EmailProducer(ArrayBlockingQueue<EmailMessage> queue) {
        this.queue = queue;
    }

    public void sendMessage(List<EmailMessage> messageList) {
        for (EmailMessage m : messageList) {
            queue.offer(m);
        }
    }
}
