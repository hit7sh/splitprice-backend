package com.splitprice.project.Controller;


import com.splitprice.project.Repository.PersonRepository;
import com.splitprice.project.dto.ExpenseRequestBodyDTO;
import com.splitprice.project.dto.contributorDTO;
import com.splitprice.project.entity.Balance;
import com.splitprice.project.entity.BalanceHistory;
import com.splitprice.project.entity.Person;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

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
        System.out.println(expenseDTO.getTotalAmt());
        Person payer = personRepository.findByEmail(expenseDTO.getPaidBy()).get();
        System.out.println(expenseDTO.getPaidBy());
        System.out.println(expenseDTO.getSplitType());
        LocalDateTime currentDateTime = LocalDateTime.now();
        if(expenseDTO.getSplitType().equals("EQUAL")){

            System.out.println("fyt");

            Integer totalContributors = 1+expenseDTO.getContributors().size();
            Double oweAmount = expenseDTO.getTotalAmt() /totalContributors;

            List<contributorDTO> contributorsList = expenseDTO.getContributors();

            payer.getBalanceSheet().addTotalAmountPaid(expenseDTO.getTotalAmt());
            payer.getBalanceSheet().addOweAmount(oweAmount);

            contributorsList.forEach((contributor)->{
                payer.getBalanceSheet().getBalanceData().forEach(frndBalance -> {
                    if(Objects.equals(frndBalance.getFriendEmail(), contributor.getEmail())){
                        frndBalance.setDelta(frndBalance.getDelta()+oweAmount);
                        BalanceHistory balanceHistory = new BalanceHistory();
                        balanceHistory.setDescription(expenseDTO.getDescription());
                        balanceHistory.setAmount(oweAmount);
                        balanceHistory.setExpenseCreatedDate(currentDateTime);
                        frndBalance.getBalanceHistoryList().add(balanceHistory);
                    }
                });

                Person frnd = personRepository.findByEmail(contributor.getEmail()).get();
                frnd.getBalanceSheet().getBalanceData().forEach(ele -> {
                    if(Objects.equals(ele.getFriendEmail(), payer.getEmail())){
                        ele.setDelta(ele.getDelta()-oweAmount);
                        BalanceHistory balanceHistory = new BalanceHistory();
                        balanceHistory.setDescription(expenseDTO.getDescription());
                        balanceHistory.setAmount(-1*oweAmount);
                        balanceHistory.setExpenseCreatedDate(currentDateTime);
                        ele.getBalanceHistoryList().add(balanceHistory);
                    }
                });

                frnd.getBalanceSheet().addDueAmount(oweAmount+0.0);

                personRepository.save(frnd);
            }


            );
            personRepository.save(payer);
        } else if (expenseDTO.getSplitType().equals("MANUAL")) {

            AtomicReference<Double> payerContribution = new AtomicReference<>(expenseDTO.getTotalAmt());

            expenseDTO.getContributors().forEach((contributor) -> {
                payerContribution.updateAndGet(v -> v - contributor.getAmount());
                Person frnd = personRepository.findByEmail(contributor.getEmail()).get();
                frnd.getBalanceSheet().addDueAmount(contributor.getAmount());
                frnd.getBalanceSheet().getBalanceData().forEach(dost -> {
                    if(Objects.equals(dost.getFriendEmail(), payer.getEmail())){
                        dost.setDelta(dost.getDelta() - contributor.getAmount());
                        BalanceHistory balanceHistory = new BalanceHistory();
                        balanceHistory.setDescription(expenseDTO.getDescription());
                        balanceHistory.setAmount(-1*contributor.getAmount());
                        balanceHistory.setExpenseCreatedDate(currentDateTime);
                        dost.getBalanceHistoryList().add(balanceHistory);
                    }

                });
                payer.getBalanceSheet().getBalanceData().forEach(frndBalance -> {
                    if(Objects.equals(frndBalance.getFriendEmail(), contributor.getEmail())){
                        frndBalance.setDelta(frndBalance.getDelta()+ contributor.getAmount());
                        BalanceHistory balanceHistory = new BalanceHistory();
                        balanceHistory.setDescription(expenseDTO.getDescription());
                        balanceHistory.setAmount(contributor.getAmount());
                        balanceHistory.setExpenseCreatedDate(currentDateTime);
                        frndBalance.getBalanceHistoryList().add(balanceHistory);
                    }
                });
            });
            payer.getBalanceSheet().addOweAmount(expenseDTO.getTotalAmt()-payerContribution.get());
            payer.getBalanceSheet().setTotalAmountPaid(expenseDTO.getTotalAmt());
        }


        return "SUCCESS";
    }

}
