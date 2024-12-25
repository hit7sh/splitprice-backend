package com.splitprice.project.dto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BalanceHistoryDTO {
    private Integer id;
    private Double amount;
    private String description;
    private LocalDateTime expenseCreatedDate;
}