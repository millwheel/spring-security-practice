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
    private String name;

    @Column
    private String password;

}
