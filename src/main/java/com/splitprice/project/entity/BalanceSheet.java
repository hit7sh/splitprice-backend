package com.splitprice.project.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

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

    public Integer getId() {
        return id;
    }

    public void addTotalAmountPaid(Double delta) {
        this.totalAmountPaid += delta;
    }
    public void addOweAmount(Double delta) {
        this.oweAmount += delta;
    }
    public void addDueAmount(Double delta){
        this.dueAmount += delta;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public void setTotalAmountPaid(Double totalAmountPaid) {
        this.totalAmountPaid = totalAmountPaid;
    }

    public Double getOweAmount() {
        return oweAmount;
    }

    public void setOweAmount(Double oweAmount) {
        this.oweAmount = oweAmount;
    }

    public Double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public List<Balance> getBalanceData() {
        return balanceData;
    }

    public void setBalanceData(List<Balance> balanceData) {
        this.balanceData = balanceData;
    }
}