package com.splitprice.project.dto;

import java.util.List;

public class ExpenseDTO {
    private String id;
    private Double totalAmount;
    private PersonDTO paidBy;
    private String description;
    private String image;
    private List<SplitDTO> splits;
    private String splitType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public PersonDTO getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(PersonDTO paidBy) {
        this.paidBy = paidBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public List<SplitDTO> getSplits() {
        return splits;
    }

    public void setSplits(List<SplitDTO> splits) {
        this.splits = splits;
    }

    public String getSplitType() {
        return splitType;
    }

    public void setSplitType(String splitType) {
        this.splitType = splitType;
    }
}