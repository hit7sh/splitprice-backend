package com.splitprice.project.dto;

import java.util.List;

public class BalanceDTO {
    private String id;
    private Double delta;
    private PersonDTO person;
    private List<BalanceHistoryDTO> balanceHistoryList;
    public String getId() {
        return id;
    }

    public List<BalanceHistoryDTO> getBalanceHistoryList() {
        return balanceHistoryList;
    }

    public void setBalanceHistoryList(List<BalanceHistoryDTO> balanceHistoryList) {
        this.balanceHistoryList = balanceHistoryList;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getDelta() {
        return delta;
    }

    public void setDelta(Double delta) {
        this.delta = delta;
    }

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(PersonDTO person) {
        this.person = person;
    }
}