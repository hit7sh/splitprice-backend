package com.splitprice.project.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double delta;

    private String friendEmail;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="balanceHistoryId")
    private List<BalanceHistory> balanceHistoryList;
}
