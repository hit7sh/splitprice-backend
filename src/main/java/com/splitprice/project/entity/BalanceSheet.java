package com.splitprice.project.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class BalanceSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double totalAmountPaid;
    private Double oweAmount;
    private Double dueAmount;

    @OneToMany(cascade=CascadeType.ALL) 
    @JoinColumn(name="balanceId")
    private List<Balance> balanceData;

    public void addTotalAmountPaid(Double delta) {
        this.totalAmountPaid += delta;
    }
    public void addOweAmount(Double delta) {
        this.oweAmount += delta;
    }
    public void addDueAmount(Double delta){
        this.dueAmount += delta;
    }
}