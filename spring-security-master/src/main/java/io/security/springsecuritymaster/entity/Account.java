package io.security.springsecuritymaster.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private int age;
    private String roles;


    public void setPassword(String password) {
        this.password = password;
    }
}
