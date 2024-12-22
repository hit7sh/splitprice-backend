package com.splitprice.project.Service;


import com.splitprice.project.entity.Person;
import org.springframework.stereotype.Service;


@Service
public interface PersonService {

    String addPerson(Person person);
    Person getPerson(String email);
    void deletePerson(String email);
    String addFriend(String emailPerson1, String emailPerson2);


}
