package com.splitprice.project.dto;

import com.splitprice.project.entity.Balance;
import lombok.Data;

import java.util.List;

@Data
public class BalanceSheetDTO {

    private String id;
    private Double totalAmountPaid;
    private Double oweAmount;
    private Double dueAmount;
    private List<Balance> balanceData;
}
