package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/homepage")
    public String userHomepage(){
        return " this is the user homepage !!";
    }

    @GetMapping("/feed")
    public String userFood(){
        return "this is the user feed !!";
    }
}
