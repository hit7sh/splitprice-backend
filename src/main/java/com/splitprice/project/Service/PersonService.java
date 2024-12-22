package com.splitprice.project.Service;


import com.splitprice.project.entity.Person;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface PersonService {

    Person addPerson(Person person);
    Person getPerson(String email);
    String deletePerson(String email);
    String addFriend(String emailPerson1, String emailPerson2);


}
