package com.splitprice.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Expense{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private double totalAmount;
    private Person paidBy;
    private String description;
    private String image;
    private List<Split> splits;
    private String splitType;
}
