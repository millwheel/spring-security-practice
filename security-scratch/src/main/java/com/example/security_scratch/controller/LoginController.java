package com.example.security_scratch.controller;

import com.example.security_scratch.dto.LoginDto;
import com.example.security_scratch.service.LoginService;
import com.example.security_scratch.util.SessionManager;
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
    private final SessionManager sessionManager;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void login(@RequestBody @Valid LoginDto loginDto, HttpServletResponse response){
        Long memberId = loginService.login(loginDto.getUsername(), loginDto.getPassword());
        sessionManager.createSession(memberId, response);
    }

}
