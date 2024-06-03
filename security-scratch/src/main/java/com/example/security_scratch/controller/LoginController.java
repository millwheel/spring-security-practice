package com.example.security_scratch.controller;

import com.example.security_scratch.dto.LoginDto;
import com.example.security_scratch.service.LoginService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void login(@RequestBody @Valid LoginDto loginDto, HttpServletResponse response){
        Long memberId = loginService.login(loginDto.getUsername(), loginDto.getPassword());
        // 쿠키에 시간 정보를 주지 않으면 세션 쿠키. 웹브라우저 종료시 삭제됨
        Cookie cookie = new Cookie("memberId", String.valueOf(memberId));
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        // 쿠키 시간 정보 설정 1일
//        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
    }

}
