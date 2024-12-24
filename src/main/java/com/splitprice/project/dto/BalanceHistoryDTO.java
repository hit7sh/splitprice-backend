package com.splitprice.project.dto;
import java.time.LocalDateTime;

public class BalanceHistoryDTO {
    private Integer id;
    private Double amount;

    private String description;
    private LocalDateTime expenseCreatedDate;
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


    public LocalDateTime getExpenseCreatedDate() {
        return expenseCreatedDate;
    }

    public void setExpenseCreatedDate(LocalDateTime expenseCreatedDate) {
        this.expenseCreatedDate = expenseCreatedDate;
    }

}