package com.example.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/")
    public String healthCheck(){
        return "Server is healthy";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/logout/success")
    public String afterLogout(){
        return "logout success";
    }

}
