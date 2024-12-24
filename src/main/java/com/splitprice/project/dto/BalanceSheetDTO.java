package com.splitprice.project.dto;
import java.util.List;

public class BalanceSheetDTO {
    private String id;
    private Double totalAmountPaid;
    private Double oweAmount;
    private Double dueAmount;
    private List<BalanceDTO> balanceData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public void setTotalAmountPaid(Double totalAmountPaid) {
        this.totalAmountPaid = totalAmountPaid;
    }

    public Double getOweAmount() {
        return oweAmount;
    }

    public void setOweAmount(Double oweAmount) {
        this.oweAmount = oweAmount;
    }

    public Double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public List<BalanceDTO> getBalanceData() {
        return balanceData;
    }

    public void setBalanceData(List<BalanceDTO> balanceData) {
        this.balanceData = balanceData;
    }

    @Override
    public String toString() {
        return "BalanceSheetDTO{" +
                "id='" + id + '\'' +
                ", totalAmountPaid=" + totalAmountPaid +
                ", oweAmount=" + oweAmount +
                ", dueAmount=" + dueAmount +
                ", balanceData=" + balanceData +
                '}';
    }
}