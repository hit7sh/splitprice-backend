package com.splitprice.project.dto;

import com.splitprice.project.entity.Balance;
import com.splitprice.project.entity.BalanceSheet;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BalanceSheetDTO {

    private String id;
    private Double totalAmountPaid;
    private Double oweAmount;
    private Double dueAmount;
    private List<BalanceDTO> balanceDataDTO;


    public BalanceSheet getEntity(){
        BalanceSheet balanceSheet = new BalanceSheet();

        balanceSheet.setId(id);
        balanceSheet.setTotalAmountPaid(totalAmountPaid);
        balanceSheet.setOweAmount(oweAmount);
        balanceSheet.setDueAmount(dueAmount);


        List<Balance> listBalance = new ArrayList<Balance>();
        balanceDataDTO.forEach((balanceDTO) -> {
            listBalance.add(balanceDTO.getEntity());
        });

        balanceSheet.setBalanceData(listBalance);
        return balanceSheet;
    }
}
