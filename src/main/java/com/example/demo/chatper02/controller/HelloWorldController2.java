package com.example.demo.chatper02.controller;

import com.example.demo.chatper02.service.IUserService;
import com.example.demo.chatper02.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class HelloWorldController2 {

    @Autowired
    IUserService userService;

    @RequestMapping("users")
    public List<User> getAllUser() {
        return userService.findAll();
    }

    @RequestMapping("user/{userName}")
    public User findByUserName(@PathVariable String userName) {
        return userService.findByUserName(userName);
    }
}
