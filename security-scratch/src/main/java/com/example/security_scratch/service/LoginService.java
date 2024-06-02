package com.example.security_scratch.service;

import com.example.security_scratch.member.Member;
import com.example.security_scratch.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public void login(String username, String password){
        Member member = memberRepository.findByUsername(username).orElseThrow();
    }
}
