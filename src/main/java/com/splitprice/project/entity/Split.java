package com.splitprice.project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
public class Split {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double amount;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personId")
    private Person person;

    public Double getAmount() {
        return amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
