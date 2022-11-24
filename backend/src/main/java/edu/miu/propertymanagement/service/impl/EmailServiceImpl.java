package edu.miu.propertymanagement.service.impl;

import edu.miu.propertymanagement.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private static final String NOREPLY_ADDRESS = "miuwaafinal@gmail.com";
    private final JavaMailSender javaMailSender;

    @Override
    public void send(String to, String subject, String body) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(NOREPLY_ADDRESS);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);

            javaMailSender.send(message);

        } catch (MailException mailException) {
            mailException.printStackTrace();
        }
    }
}
