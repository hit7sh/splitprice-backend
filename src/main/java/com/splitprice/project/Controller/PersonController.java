package com.splitprice.project.Controller;

import com.splitprice.project.Service.ExpenseService;
import com.splitprice.project.Service.PersonService;
import com.splitprice.project.configurations.ModelMapperConfig;
import com.splitprice.project.dto.ExpenseRequestBodyDTO;
import com.splitprice.project.dto.PersonDTO;
import com.splitprice.project.entity.Expense;
import com.splitprice.project.entity.Person;
import com.splitprice.project.exceptionHandler.ArgumentMethodInValidException;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/person")
@Transactional
@Validated
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private ExpenseService expenseService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/add")
    @Operation(summary = "Greet user")
    public ResponseEntity<Person> addPerson(@RequestBody @Valid PersonDTO personDTO) throws MethodArgumentNotValidException, Exception {
        Person person = modelMapper.map(personDTO, Person.class);
        return ResponseEntity.status(HttpStatus.OK).body(personService.addPerson(person));
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<List<Person>> getAllPerson() throws Exception {
        List<Person> personList = personService.getAllPerson();
        return ResponseEntity.status(HttpStatus.OK).body(personList);
    }

    @GetMapping("/get-user/{email}")
    @Operation(summary = "Greet email")
    public ResponseEntity<Person> getPerson(
            @PathVariable @Email(message = "Not a Valid Email Format") String email
    ) throws ConstraintViolationException, Exception {
        return ResponseEntity.status(HttpStatus.OK).body(personService.getPerson(email));
    }

    @DeleteMapping("/delete-user/{email}")
    @Operation(summary = "Greet Delete")
    public ResponseEntity<String> deletePerson(
            @PathVariable @Email(message = "Not a Valid Email Format") String email
    ) throws ConstraintViolationException, Exception {
        return ResponseEntity.status(HttpStatus.OK).body(personService.deletePerson(email));
    }

    @PostMapping("/add-friend/{user1}/{user2}")
    @Operation(summary = "add friend")
    public ResponseEntity<String> addFriend(
            @PathVariable @Email(message = "Not a Valid Email Format") String user1,
            @PathVariable @Email(message = "Not a Valid Email Format") String user2
    ) throws ConstraintViolationException, Exception {
        return ResponseEntity.status(HttpStatus.OK).body( personService.addFriend(user1,user2));
    }

    @PostMapping("/add-expense")
    @Operation(summary = "add expense")
    public  ResponseEntity<String> addExpense(
            @RequestBody @Valid ExpenseRequestBodyDTO expenseRequestBodyDTO
    ) throws MethodArgumentNotValidException, Exception  {
        return ResponseEntity.status(HttpStatus.OK).body( expenseService.addExpense(expenseRequestBodyDTO));
    }
}
