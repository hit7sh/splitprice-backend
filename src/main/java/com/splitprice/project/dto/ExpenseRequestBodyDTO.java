package com.splitprice.project.dto;

import com.splitprice.project.entity.Person;
import com.splitprice.project.entity.Split;

import java.util.List;

public class ExpenseRequestBodyDTO {

    Person paidBy;
    Integer totalAmt;
    String splitTYpe;
    List<contributorDTO> contributors;

    public Person getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(Person paidBy) {
        this.paidBy = paidBy;
    }

    public Integer getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(Integer totalAmt) {
        this.totalAmt = totalAmt;
    }

    public String getSplitTYpe() {
        return splitTYpe;
    }

    public void setSplitTYpe(String splitTYpe) {
        this.splitTYpe = splitTYpe;
    }

    public List<contributorDTO> getContributors() {
        return contributors;
    }

    public void setContributors(List<contributorDTO> contributors) {
        this.contributors = contributors;
    }

}
