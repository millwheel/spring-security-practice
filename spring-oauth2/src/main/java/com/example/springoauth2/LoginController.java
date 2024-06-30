package com.example.springoauth2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/loginPage")
    public String loginPage() {
        return "Welcome to Spring Security Practice";
    }

}
