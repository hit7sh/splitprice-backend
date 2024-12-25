package com.splitprice.project.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class contributorDTO {
    @Email(message="INVLID EMAIL in contributors array")
    String email;

    Double percentage;
    Double amount;

    @Override
    public String toString() {
        return "contributorDTO{" +
                "email='" + email + '\'' +
                ", percentage=" + percentage +
                ", amount=" + amount +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
