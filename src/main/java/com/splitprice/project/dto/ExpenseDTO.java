package com.splitprice.project.dto;

import lombok.Data;

import java.util.List;

@Data
public class ExpenseDTO {
    private String id;
    private Double totalAmount;
    private PersonDTO paidBy;
    private String description;
    private String image;
    private List<SplitDTO> splits;
    private String splitType;
}