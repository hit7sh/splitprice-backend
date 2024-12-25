package com.splitprice.project.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PersonDTO {
    private String id;
    @Size(min = 3, max = 50)
    private String name;
    @Email
    private String email;
    @NotNull
    private BalanceSheetDTO balanceSheet;
}