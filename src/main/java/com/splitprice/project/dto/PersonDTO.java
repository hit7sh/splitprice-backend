package com.splitprice.project.dto;

import com.splitprice.project.entity.BalanceSheet;
import com.splitprice.project.entity.Person;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class PersonDTO {
    private String id;

    private String name;
    private String email;

    private BalanceSheetDTO balanceSheetDTO;

    public Person getEntity() {
        Person person = new Person();
        person.setId(id);
        person.setEmail(email);
        person.setName(name);

        BalanceSheet balanceSheet = balanceSheetDTO.getEntity();
        person.setBalanceSheet(balanceSheet);
        return person;
    }
}
