package com.example.security_scratch.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Member {

    @Id
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    public static Member createMember(String username, String password){
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);
        return member;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
