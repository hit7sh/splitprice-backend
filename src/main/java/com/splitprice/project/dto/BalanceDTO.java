package com.splitprice.project.dto;

import lombok.Data;
import java.util.List;

@Data
public class BalanceDTO {
    private String id;
    private Double delta;
    private PersonDTO person;
    private List<BalanceHistoryDTO> balanceHistoryList;
}