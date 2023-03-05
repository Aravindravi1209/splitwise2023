package com.splitwise.splitwise2023.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateGroupRequestDto {
    private String name;
    private Long createdByUserId;
    private String description;
}
