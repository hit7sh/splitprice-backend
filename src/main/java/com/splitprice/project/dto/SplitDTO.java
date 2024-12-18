package com.splitprice.project.dto;

import com.splitprice.project.entity.Person;
import lombok.Data;


@Data
public class SplitDTO {

    private String id;
    private Double amount;
    private Person person;
}
