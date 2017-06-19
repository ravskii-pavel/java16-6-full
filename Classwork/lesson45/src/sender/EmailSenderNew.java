package sender;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by java on 21.04.2017.
 */
public enum EmailSenderNew {

    INSTANCE;

    /*private volatile static sender.EmailSenderNew instance;

    private sender.EmailSenderNew(){
    }

    private static sender.EmailSenderNew getInstance(){
        if (instance != null) return instance;

        synchronized(sender.EmailSenderNew.class){
            if (null == instance){
                instance = new sender.EmailSenderNew();
            }
        }
        return instance;
    }*/
    public static void sendEmail(String clientEmail, String messageText, String subject) {
        //String to = "levelup.java.16.6@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "levelup.java.16.6@gmail.com";
        final String password = "JavaLevelUp166";
        // Assuming you are sending email from localhost
        //String host = "smtp.gmail.com";

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
            System.out.println("Sent message successfully to: " + clientEmail);
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}