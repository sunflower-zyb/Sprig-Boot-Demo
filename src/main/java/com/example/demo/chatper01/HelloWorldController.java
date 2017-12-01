package com.example.demo.chatper01;


import com.example.demo.chatper02.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Value("${name}")
    private String name;

    @Autowired
    User user;

    @RequestMapping("/hello")
    public String index() {
//        return name;
        return user.getUserName();
    }

}
