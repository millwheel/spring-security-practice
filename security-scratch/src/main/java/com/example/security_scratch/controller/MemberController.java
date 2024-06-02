package com.example.security_scratch.controller;

import com.example.security_scratch.dto.MemberCreateDto;
import com.example.security_scratch.member.Member;
import com.example.security_scratch.repository.MemberRepository;
import com.example.security_scratch.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public void addMember(@RequestBody @Valid MemberCreateDto memberCreateDto){
        memberService.addMember(memberCreateDto.getUsername(), memberCreateDto.getPassword());
    }

}
