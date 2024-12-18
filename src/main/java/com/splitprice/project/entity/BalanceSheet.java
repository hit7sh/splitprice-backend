package com.splitprice.project.entity;

import jakarta.persistence.*;
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

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="balanceId")
    private List<Balance> balanceData;

}
