package com.splitprice.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Split {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private Double amount;
    private Person person;
}
