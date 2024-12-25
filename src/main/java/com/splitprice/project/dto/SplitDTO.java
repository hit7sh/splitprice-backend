package com.splitprice.project.dto;

import lombok.Data;

@Data
public class SplitDTO {
    private String id;
    private Double amount;
    private PersonDTO person;
}