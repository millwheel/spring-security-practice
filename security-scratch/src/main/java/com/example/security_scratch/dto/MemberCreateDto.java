package com.example.security_scratch.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MemberCreateDto {

    @NotNull
    private String username;
    @NotNull
    private String password;

}
