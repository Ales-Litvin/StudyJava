package by_epam.introduction_to_java.tasks_6.task01.network;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.util.Properties;

public class Email {
    public static void main(String[] args) throws IOException, MessagingException {

        // it works Aaaaaaaaaaaaa
        // чтение properties
        final Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtps");
        properties.setProperty("mail.smtps.auth", "true");
        properties.setProperty("mail.smtps.host", "547"); //smtp.gmail.com
        properties.setProperty("mail.smtps.user", "ssaannyyaa25@gmail.com");


        // тастройка сообщения
        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("ssaannyyaa25")); // отправитель
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("rachko.a.ch@gmail.com")); // email To кому?
        message.setSubject("Hello, it from Java");
        message.setText("Hi this is my text message, from Java program");

        // отправление
        Transport tr = mailSession.getTransport();
        tr.connect(null, "sanya252115");
        tr.sendMessage(message, message.getAllRecipients());
        tr.close();

        // You need view Message what send you need change your options security
        // in email service.
        
    }
}
