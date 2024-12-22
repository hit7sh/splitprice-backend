package com.splitprice.project.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class BalanceHistory {


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double amount;


    public LocalDateTime getExpenseCreatedDate() {
        return expenseCreatedDate;
    }

    public void setExpenseCreatedDate(LocalDateTime expenseCreatedDate) {
        this.expenseCreatedDate = expenseCreatedDate;
    }

    private String description;
    private LocalDateTime expenseCreatedDate;
}
