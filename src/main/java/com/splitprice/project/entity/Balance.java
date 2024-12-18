package com.splitprice.project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private Double delta;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="personId")
    private Person person;
}
