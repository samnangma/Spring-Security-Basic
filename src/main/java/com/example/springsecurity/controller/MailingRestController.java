package com.example.springsecurity.controller;

import com.example.springsecurity.service.MailingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
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

    @PostMapping("/sending-styled-mail")
    public String sendingBetterMail(){
        try {

            mailingService.sendMailWithStyle();
            return "Successfully sendind mail";

        } catch (Exception ex) {
            ex.printStackTrace();
            return "Failed to send the html mail";
        }
    }
}
