package com.example.security_scratch.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginDto {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
