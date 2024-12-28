package com.splitprice.project.Service;


import com.splitprice.project.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface PersonService {

    Person addPerson(Person person) throws Exception;
    Person getPerson(String email) throws Exception;
    String deletePerson(String email) throws Exception;
    String addFriend(String emailPerson1, String emailPerson2) throws Exception;
    List<Person> getAllPerson() throws Exception;


}
