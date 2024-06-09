package com.example.cors2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/users")
    public String users(){
        return "{\"name\":\"론다 로우지\"}";
    }

}
