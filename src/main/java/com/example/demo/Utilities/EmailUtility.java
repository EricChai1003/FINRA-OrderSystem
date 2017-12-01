package com.example.demo.Utilities;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class EmailUtility {

    public final static String toEmail = "";
    public final static String fromEmail = "";
    public final static MailSender mailSender = new MailSender() {
        @Override
        public void send(SimpleMailMessage simpleMailMessage) throws MailException {
        }

        @Override
        public void send(SimpleMailMessage... simpleMailMessages) throws MailException {
        }
    };

    public static void sendEmail(String text, String to, String from) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(text);
        message.setTo(to);
        message.setFrom(from);
        mailSender.send(message);
    }
}
