package com.example.springsecurity.controller;

import com.example.springsecurity.service.MailingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailingRestController {

    private final MailingService mailingService;

    MailingRestController(MailingService mailingService){
        this.mailingService = mailingService;
    }

    @PostMapping("/sendingmail")
    public String sendMail() {
    try{
        mailingService.sendEmail("samnangma6@gmail.com","Here is the description","Sending from the application ");

        return "Successfully sending mail ";

    } catch (Exception ex){
        System.out.println("Ex "+ex.getMessage());
        return "Failed to send email ";
    }
    }
}
