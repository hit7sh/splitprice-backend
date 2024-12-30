package com.splitprice.project.Service;

import com.splitprice.project.Repository.PersonRepository;
import com.splitprice.project.entity.Balance;
import com.splitprice.project.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@Service
public class PersonServiceImpl implements PersonService{



    @Autowired
    private PersonRepository personRepository;


    public Person addPerson(Person person) throws Exception {
          return personRepository.save(person);
    }


    public Person getPerson(String email) throws Exception {
        return personRepository.findByEmail(email).get();
    }

    public List<Person> getAllPerson() throws Exception {
        return personRepository.findAll();
    }



    public String deletePerson(String email){
        personRepository.deleteByEmail(email);
        return "DELETED";
    }


    public String addFriend( String user1,String user2){
        Person A = personRepository.findByEmail(user1).get();
        Person B = personRepository.findByEmail(user2).get();

        Balance obj1 = new Balance();
        obj1.setDelta(0.0);
        obj1.setFriendEmail(B.getEmail());
        obj1.setFriendName(B.getName());
        A.getBalanceSheet().getBalanceData().add(obj1);
        Balance obj2 = new Balance();
        obj2.setDelta(0.0);
        obj2.setFriendEmail(A.getEmail());
        obj2.setFriendName(A.getName());
        B.getBalanceSheet().getBalanceData().add(obj2);

        personRepository.save(A);
        personRepository.save(B);
        return "Success";
    }
}
