package com.splitprice.project.dto;

import com.splitprice.project.entity.Person;
import lombok.Data;

@Data
public class BalanceDTO {

    private String id;
    private Double delta;
    private Person person;



}
