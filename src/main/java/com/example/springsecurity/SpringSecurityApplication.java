package com.example.springsecurity;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        // when the application , we will load the file
        Dotenv dotenv = Dotenv.configure().load();
        System.setProperty("MAIL_SEVER", dotenv.get("MAIL_SEVER"));
        System.setProperty("APP_PASSWORD", dotenv.get("APP_PASSWORD"));
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

}
