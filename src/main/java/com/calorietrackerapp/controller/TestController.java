package com.calorietrackerapp.controller;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return " Hello from Calorie Tracker Backend!";
    }

    //create a new user
    @PostMapping("/create")
    public String createUser(User user){
        return "User created: " + user.getName();
    }
}