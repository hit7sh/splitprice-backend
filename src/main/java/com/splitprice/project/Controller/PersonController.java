package com.splitprice.project.Controller;


import com.splitprice.project.Repository.PersonRepository;
import com.splitprice.project.dto.ExpenseRequestBodyDTO;
import com.splitprice.project.dto.contributorDTO;
import com.splitprice.project.entity.Balance;
import com.splitprice.project.entity.Person;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@Transactional
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/add")
    public String addPerson(@RequestBody Person person){
        System.out.print("Person details"+ " "+person.getName());
       personRepository.save(person);
       return "Success";
    }

    @GetMapping("/get-user/{email}")
    public Person getPerson(@PathVariable String email) {
       return personRepository.findByEmail(email).get();
    }


    @DeleteMapping("/delete-user/{email}")
    public void deleteUser(@PathVariable String email){
         personRepository.deleteByEmail(email);
    }

    @PostMapping("/add-friend/{user1}/{user2}")
    public String addFriend(@PathVariable String user1,@PathVariable String user2){
        Person A = personRepository.findByEmail(user1).get();
        Person B = personRepository.findByEmail(user2).get();


        Balance obj1 = new Balance();
        obj1.setDelta(0.0);
        obj1.setFriendEmail(B.getEmail());

        A.getBalanceSheet().getBalanceData().add(obj1);

        Balance obj2 = new Balance();
        obj2.setDelta(0.0);
        obj2.setFriendEmail(A.getEmail());

        B.getBalanceSheet().getBalanceData().add(obj2);

        personRepository.save(A);
        personRepository.save(B);

        return "Success";
    }

    @PostMapping("/add-expense")
    public String addExpense(@RequestBody ExpenseRequestBodyDTO expenseDTO){

        Person payer = personRepository.findByEmail(expenseDTO.getPaidBy().getEmail()).get();

        if(expenseDTO.getSplitTYpe() == "EQUAL"){

            Integer totalContributors = 1+expenseDTO.getContributors().size();
            Double oweAmount = expenseDTO.getTotalAmt().doubleValue()/totalContributors;

            List<contributorDTO> contributorsList = expenseDTO.getContributors();

            payer.getBalanceSheet().setTotalAmountPaid(expenseDTO.getTotalAmt()+0.0);

            contributorsList.forEach((contributor)->{
                payer.getBalanceSheet().getBalanceData().forEach(frndBalance -> {
                    if(frndBalance.getFriendEmail() == contributor.getEmail()){
                        frndBalance.setDelta(frndBalance.getDelta()+oweAmount);
                    }
                });

                Person frnd = personRepository.findByEmail(contributor.getEmail()).get();

            }
            );

        }


        return "SUCCESS";
    }

}
