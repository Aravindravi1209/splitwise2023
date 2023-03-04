package com.splitwise.splitwise2023.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDto {
    private String username;
    private String password;
    private String phoneNumber;
}
