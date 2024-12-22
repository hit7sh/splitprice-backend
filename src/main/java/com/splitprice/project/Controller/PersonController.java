package com.splitprice.project.Controller;

import com.splitprice.project.Service.ExpenseService;
import com.splitprice.project.Service.PersonService;
import com.splitprice.project.dto.ExpenseRequestBodyDTO;
import com.splitprice.project.entity.Person;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Person> addPerson(@RequestBody Person person){

        return ResponseEntity.status(HttpStatus.OK).body(personService.addPerson(person));
    }

    @GetMapping("/get-user/{email}")
    public ResponseEntity<Person> getPerson(@PathVariable String email) {

        return ResponseEntity.status(HttpStatus.OK).body(personService.getPerson(email));
    }

    @DeleteMapping("/delete-user/{email}")
    public ResponseEntity<String> deletePerson(@PathVariable String email){

        return ResponseEntity.status(HttpStatus.OK).body(personService.deletePerson(email));
    }

    @PostMapping("/add-friend/{user1}/{user2}")
    public ResponseEntity<String> addFriend(@PathVariable String user1,@PathVariable String user2){
        return ResponseEntity.status(HttpStatus.OK).body( personService.addFriend(user1,user2));
    }

    @PostMapping("/add-expense")
    public  ResponseEntity<String> addExpense(@RequestBody ExpenseRequestBodyDTO expenseDTO){
        return ResponseEntity.status(HttpStatus.OK).body( expenseService.addExpense(expenseDTO));
    }
}
