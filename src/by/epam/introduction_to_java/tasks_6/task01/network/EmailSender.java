package by.epam.introduction_to_java.tasks_6.task01.network;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

/**
 * This class use for sends email.
 */
public class EmailSender {
    /**
     * Sends messages to recipients.
     * @throws MessagingException if was except situation.
     */
    public static void sendMessage(
            String from,
            String password,
            String[] recipients,
            String subject,
            String text) throws MessagingException{

        // Creates Session using properties.
        Session mailSession = Session.getDefaultInstance(getProperties(from));

        // Creates message
        MimeMessage message = new MimeMessage(mailSession);

        message.setFrom(new InternetAddress(from));
        message.addRecipients(Message.RecipientType.BCC, getAddresses(recipients));

        message.setSubject(subject);
        message.setText(text);

        // Sending
        Transport tr = mailSession.getTransport();
        tr.connect(null, password);
        tr.sendMessage(message, message.getAllRecipients());
        tr.close();
    }

    /**
     * Returns array fo addresses.
     */
    private static Address[] getAddresses(String[] recipients) throws AddressException {
        Address[] addresses = new Address[recipients.length];

        for (int i = 0; i < recipients.length; i++){
            addresses[i] = new InternetAddress(recipients[i]);
        }
        return addresses;
    }

    /**
     * Returns properties for sending email from Gmail.
     */
    private static Properties getProperties(String email){
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtps");
        properties.setProperty("mail.smtps.auth", "true");
        properties.setProperty("mail.smtps.host", "smtp.gmail.com");
        properties.setProperty("mail.smtps.user", email);
        return properties;
    }
}
