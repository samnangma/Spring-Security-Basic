package com.example.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    // Controller works with view engine
    @GetMapping("/homepage")
    @ResponseBody
    public String adminHomePage(){
        return "This is the admin homepage";
    }

    @GetMapping("/feed")
    @ResponseBody
    public String adminFeed(){
        return "this is the admin feed page";
    }
}
