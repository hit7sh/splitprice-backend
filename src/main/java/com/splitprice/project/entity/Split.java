package com.splitprice.project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Split {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private Double amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personId")
    private Person person;
}
