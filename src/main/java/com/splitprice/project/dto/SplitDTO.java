package com.splitprice.project.dto;

import com.splitprice.project.entity.Person;
import com.splitprice.project.entity.Split;
import lombok.Data;


@Data
public class SplitDTO {

    private String id;
    private Double amount;
    private PersonDTO personDTO;

    public Split getEntity() {
        Split split = new Split();
        split.setId(id);
        split.setAmount(amount);

        Person person = personDTO.getEntity();
        split.setPerson(person);

        return split;
    }
}
