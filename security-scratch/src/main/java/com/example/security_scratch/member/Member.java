package com.example.security_scratch.member;

import com.example.security_scratch.util.PasswordHashing;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Member {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public boolean matchPassword(String password){
        return this.hashedPassword.equals(PasswordHashing.hashPassword(password));
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private void setPassword(String hashedPassword){
        this.hashedPassword = hashedPassword;
    }

}
