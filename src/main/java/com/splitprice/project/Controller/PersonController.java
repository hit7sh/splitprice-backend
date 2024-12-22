package com.splitprice.project.Controller;

import com.splitprice.project.Service.ExpenseService;
import com.splitprice.project.Service.PersonService;
import com.splitprice.project.dto.ExpenseRequestBodyDTO;
import com.splitprice.project.entity.Person;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@Transactional
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/add")
    public String addPerson(@RequestBody Person person){
       return personService.addPerson(person);
    }

    @GetMapping("/get-user/{email}")
    public Person getPerson(@PathVariable String email) {
       return personService.getPerson(email);
    }

    @DeleteMapping("/delete-user/{email}")
    public void deletePerson(@PathVariable String email){
         personService.deletePerson(email);
    }

    @PostMapping("/add-friend/{user1}/{user2}")
    public String addFriend(@PathVariable String user1,@PathVariable String user2){
        return personService.addFriend(user1,user2);
    }

    @PostMapping("/add-expense")
    public String addExpense(@RequestBody ExpenseRequestBodyDTO expenseDTO){
        return expenseService.addExpense(expenseDTO);
    }
}
