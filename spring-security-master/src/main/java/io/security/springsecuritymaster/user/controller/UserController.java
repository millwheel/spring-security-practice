package io.security.springsecuritymaster.user.controller;

import io.security.springsecuritymaster.dto.AccountDto;
import io.security.springsecuritymaster.entity.Account;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public String signUp(AccountDto accountDto){
        ModelMapper mapper = new ModelMapper();
        Account account = mapper.map(accountDto, Account.class);
        account.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        return "redirect:/";
    }
}
