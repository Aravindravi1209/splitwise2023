package com.splitwise.splitwise2023.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Currency extends BaseModel{
    private String name;

}
