package com.splitprice.project.dto;

import com.splitprice.project.entity.Person;
import com.splitprice.project.entity.Split;

import java.util.List;

public class ExpenseRequestBodyDTO {

    String paidBy;
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
