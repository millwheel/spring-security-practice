package com.example.security_scratch.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String healthCheckController(){
        return "Server was activated successfully";
    }
}
