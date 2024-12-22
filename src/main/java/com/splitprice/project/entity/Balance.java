package com.splitprice.project.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

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

    public List<BalanceHistory> getBalanceHistoryList() {
        return balanceHistoryList;
    }

    public void setBalanceHistoryList(List<BalanceHistory> balanceHistoryList) {
        this.balanceHistoryList = balanceHistoryList;
    }

    public String getFriendEmail() {
        return friendEmail;
    }

    public void setFriendEmail(String friendEmail) {
        this.friendEmail = friendEmail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDelta() {
        return delta;
    }

    public void setDelta(Double delta) {
        this.delta = delta;
    }


}
