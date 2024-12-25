package com.splitprice.project.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PersonDTO {
    private String id;
    @Size(min = 3, max = 50)
    private String name;
    @Email
    private String email;
    @NotNull
    private BalanceSheetDTO balanceSheet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BalanceSheetDTO getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(BalanceSheetDTO balanceSheet) {
        this.balanceSheet = balanceSheet;
    }
}