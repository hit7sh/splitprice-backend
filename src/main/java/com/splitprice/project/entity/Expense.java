package com.splitprice.project.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Expense{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private Double totalAmount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personId")
    private Person paidBy;
    private String description;
    private String image;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "splitId")
    private List<Split> splits;

    private String splitType;
}
