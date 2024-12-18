package com.splitprice.project.dto;


import com.splitprice.project.entity.Person;
import com.splitprice.project.entity.Split;
import lombok.Data;

import java.util.List;

@Data
public class ExpenseDTO {

    private String id;
    private Double totalAmount;
    private Person paidBy;
    private String description;
    private String image;
    private List<Split> splits;
    private String splitType;
}
