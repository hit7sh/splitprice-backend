package com.splitprice.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class BalanceSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private Double totalAmountPaid;
    private Double oweAmount;
    private Double dueAmount;

    private List<Balance> balanceData;

}
