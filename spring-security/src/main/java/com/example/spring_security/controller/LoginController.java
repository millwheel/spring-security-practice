package com.example.spring_security.controller;

import com.example.spring_security.SessionInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final SessionInfoService sessionInfoService;

    @GetMapping("/")
    public String healthCheck(){
        return "Server is healthy";
    }

    @GetMapping("/member/only")
    public String memberOnly(){
        return "member only. secured api";
    }

    @GetMapping("/logout/success")
    public String afterLogout(){
        return "logout success";
    }

    @GetMapping("/roles")
    public String index(){
        SecurityContext context = SecurityContextHolder.getContextHolderStrategy().getContext();
        Authentication authentication = context.getAuthentication();
        List<String> authoritiesStrings = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        return String.format("including authority: %s", authoritiesStrings.get(0));
    }

    @GetMapping("/session/expired")
    public String expired(){
        return "expired session.";
    }

    @GetMapping("/session/invalid")
    public String invalidSession(){
        return "invalid session.";
    }

    @GetMapping("/session/info")
    public String sessionInfo(){
        sessionInfoService.sessionInfo();
        return "session info";
    }

}
