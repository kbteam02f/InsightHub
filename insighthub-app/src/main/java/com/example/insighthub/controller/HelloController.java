package com.example.insighthub.controller;

import com.example.insighthub.model.User;
import com.example.insighthub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping("hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("adult")
    public List<User> getAdultUsers() {
        return userService.getAdults();
    }
}
