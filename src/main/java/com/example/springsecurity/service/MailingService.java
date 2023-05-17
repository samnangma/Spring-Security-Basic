package com.example.springsecurity.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.InternetAddressEditor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class MailingService {

    @Autowired
    JavaMailSender javaMailSender;
    public void sendEmail(String to, String subject, String description) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(description);
        javaMailSender.send(simpleMailMessage);
    }
    public void sendMailWithStyle() throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        //sender
        message.setFrom(new InternetAddress("masamanng6@gmail.com"));
        message.setRecipients(MimeMessage.RecipientType.TO, "samnangma6@gmail.com");

        String messageContent = """
                    <!DOCTYPE html>
                    <html lang="en">
                    <head>
                        <meta charset="UTF-8">
                        <meta http-equiv="X-UA-Compatible" content="IE=edge">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title>Document</title>
                    
                         <style>
                            .reciever{
                                color: orange;
                            }
                    
                            .token{
                                font-size: 40px;
                                font-weight: bold;
                                color: orange;
                            }
                         </style>
                    </head>
                    <body>
                       \s
                            <h1> Greeting from <span class="receiver"> Bona </span></h1>
                            <p> here is your token <span class="token"> 1234567</span> </p>
                    
                    
                    </body>
                    </html>
                """;
        message.setContent(messageContent  , "text/html; charset=utf-8");
        javaMailSender.send(message);


    }


}
