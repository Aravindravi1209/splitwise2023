package com.splitwise.splitwise2023.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProfileRequestDto {
    private Long userId;
    private String newPassword;
}
