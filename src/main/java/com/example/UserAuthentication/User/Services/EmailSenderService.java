package com.example.UserAuthentication.User.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail, String subjet, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("kuabteste@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subjet);

        mailSender.send(message);

        System.out.println("Mail send successfully...");
    }

}
