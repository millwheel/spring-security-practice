package com.example.security_scratch.controller;

import com.example.security_scratch.dto.LoginDto;
import com.example.security_scratch.service.LoginService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void login(@RequestBody @Valid LoginDto loginDto, HttpServletResponse response){
        Long memberId = loginService.login(loginDto.getUsername(), loginDto.getPassword());
        // Create a session cookie
        Cookie cookie = new Cookie("memberId", String.valueOf(memberId));
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        // Set cookie max age to 1 day
        // cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
    }

}
