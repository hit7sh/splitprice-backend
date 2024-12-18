package com.splitprice.project.dto;

import com.splitprice.project.entity.BalanceSheet;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class PersonDTO {
    private String id;

    private String name;
    private String email;

    private BalanceSheet balanceSheet;
}
