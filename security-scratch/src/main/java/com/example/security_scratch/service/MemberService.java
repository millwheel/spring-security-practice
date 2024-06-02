package com.example.security_scratch.service;


import com.example.security_scratch.member.Member;
import com.example.security_scratch.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void addMember(String username, String password){
        Member member = Member.createMember(username, password);
        memberRepository.save(member);
    }

}
