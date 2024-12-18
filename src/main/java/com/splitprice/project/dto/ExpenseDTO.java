package com.splitprice.project.dto;


import com.splitprice.project.entity.Expense;
import com.splitprice.project.entity.Person;
import com.splitprice.project.entity.Split;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExpenseDTO {

    private String id;
    private Double totalAmount;
    private PersonDTO paidBy;
    private String description;
    private String image;
    private List<SplitDTO> splitsDTO;
    private String splitType;

    public Expense getEntity(){
        Expense expense = new Expense();

        expense.setId(id);
        expense.setTotalAmount(totalAmount);
        expense.setDescription(description);
        expense.setImage(image);
        expense.setSplitType(splitType);

        Person person = paidBy.getEntity();
        expense.setPaidBy(person);

        List<Split> splitList = new ArrayList<>();

        splitsDTO.forEach((split)->{
            splitList.add(split.getEntity());
        });
        expense.setSplits(splitList);
        return expense;
    }
}
