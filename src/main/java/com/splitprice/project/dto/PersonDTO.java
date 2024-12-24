package com.splitprice.project.dto;

public class PersonDTO {
    private String id;
    private String name;
    private String email;
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