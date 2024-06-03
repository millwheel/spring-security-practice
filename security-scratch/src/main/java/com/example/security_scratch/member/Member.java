package com.example.security_scratch.member;

import com.example.security_scratch.util.PasswordHashing;
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
    private String hashedPassword;

    public static Member createMember(String username, String password){
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(PasswordHashing.hashPassword(password));
        return member;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private void setPassword(String hashedPassword){
        this.hashedPassword = hashedPassword;
    }

}
