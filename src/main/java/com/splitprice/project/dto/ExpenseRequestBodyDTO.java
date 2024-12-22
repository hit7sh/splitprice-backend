package com.splitprice.project.dto;

import com.splitprice.project.entity.Person;
import com.splitprice.project.entity.Split;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.List;


public class ExpenseRequestBodyDTO {

    @Email(message = "Enter valid email format")
    String paidBy;

    @Min(value = 0, message = "Enter positive(+ve) value")
    Double totalAmt;
    String description;
    String splitType;
    List<contributorDTO> contributors;

    public String getPaidBy() {
        return paidBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    public Double getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(Double totalAmt) {
        this.totalAmt = totalAmt;
    }

    public String getSplitType() {
        return splitType;
    }

    public void setSplitType(String splitType) {
        this.splitType = splitType;
    }

    public List<contributorDTO> getContributors() {
        return contributors;
    }

    public void setContributors(List<contributorDTO> contributors) {
        this.contributors = contributors;
    }

}
