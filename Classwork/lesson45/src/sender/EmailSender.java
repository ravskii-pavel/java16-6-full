package sender;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by java on 21.04.2017.
 */
public enum EmailSender {

    INSTANCE;

//    private volatile static EmailSender instance;
//
//    private EmailSender() {
//    }
//
//    public static EmailSender getInstance() {
//        if (instance != null) return instance;
//
//        synchronized (EmailSender.class) {
//            if(null == instance) {
//                instance = new EmailSender();
//            }
//        }
//
//        return instance;
//    }

    private volatile Lock lock = new ReentrantLock();


    public void sendEmail(String clientEmail, String messageText, String subject) {
       lock.lock();

        // Recipient's email ID needs to be mentioned.
//        String to = "levelup.java.16.6@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "levelup.java.16.6@gmail.com";

        // Sender's password needs to be mentioned
        final String password = "JavaLevelUp166";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(clientEmail));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(messageText);

            // Send message
            Transport.send(message);
            System.out.println(new Date() + " Sent message successfully to: " + clientEmail);
            Thread.sleep(3000);
        } catch (MessagingException | InterruptedException mex) {
            mex.printStackTrace();
        }

        lock.unlock();
    }
}
