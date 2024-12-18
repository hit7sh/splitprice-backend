package com.splitprice.project.dto;

import com.splitprice.project.entity.Balance;
import com.splitprice.project.entity.Person;
import lombok.Data;

@Data
public class BalanceDTO {

    private String id;
    private Double delta;
    private PersonDTO personDTO;

    public Balance getEntity() {
        Balance balance = new Balance();
        balance.setId(id);
        balance.setDelta(delta);

        Person person = personDTO.getEntity();
        balance.setPerson(person);
        return balance;
    }

}
