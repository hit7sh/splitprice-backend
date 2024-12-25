package com.splitprice.project.Service;

import com.splitprice.project.Repository.PersonRepository;
import com.splitprice.project.dto.ExpenseRequestBodyDTO;
import com.splitprice.project.dto.contributorDTO;
import com.splitprice.project.entity.BalanceHistory;
import com.splitprice.project.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private PersonRepository personRepository;


    public void handleEqualExpense(ExpenseRequestBodyDTO expenseRequestBodyDTO, Person payer, LocalDateTime currentDateTime){

        Integer totalContributors = 1+expenseRequestBodyDTO.getContributors().size();
        Double oweAmount = expenseRequestBodyDTO.getTotalAmt() /totalContributors;

        List<contributorDTO> contributorsList = expenseRequestBodyDTO.getContributors();

        payer.getBalanceSheet().addTotalAmountPaid(expenseRequestBodyDTO.getTotalAmt());
        payer.getBalanceSheet().addOweAmount(oweAmount);

        contributorsList.forEach((contributor)->{
                    payer.getBalanceSheet().getBalanceData().forEach(frndBalance -> {
                        if(Objects.equals(frndBalance.getFriendEmail(), contributor.getEmail())){
                            frndBalance.setDelta(frndBalance.getDelta()+oweAmount);
                            BalanceHistory balanceHistory = new BalanceHistory();
                            balanceHistory.setDescription(expenseRequestBodyDTO.getDescription());
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
                            balanceHistory.setDescription(expenseRequestBodyDTO.getDescription());
                            balanceHistory.setAmount(-1*oweAmount);
                            balanceHistory.setExpenseCreatedDate(currentDateTime);
                            ele.getBalanceHistoryList().add(balanceHistory);
                        }
                    });

                    frnd.getBalanceSheet().addDueAmount(oweAmount+0.0);
                    System.out.println("FRND == "+frnd);
                    personRepository.save(frnd);
                }


        );
        personRepository.save(payer);

    }

    public void handleManualExpense(ExpenseRequestBodyDTO expenseRequestBodyDTO, Person payer, LocalDateTime currentDateTime){


        AtomicReference<Double> payerContribution = new AtomicReference<>(expenseRequestBodyDTO.getTotalAmt());

        expenseRequestBodyDTO.getContributors().forEach((contributor) -> {
            payerContribution.updateAndGet(v -> v - contributor.getAmount());
            Person frnd = personRepository.findByEmail(contributor.getEmail()).get();
            frnd.getBalanceSheet().addDueAmount(contributor.getAmount());
            frnd.getBalanceSheet().getBalanceData().forEach(dost -> {
                if(Objects.equals(dost.getFriendEmail(), payer.getEmail())){
                    dost.setDelta(dost.getDelta() - contributor.getAmount());
                    BalanceHistory balanceHistory = new BalanceHistory();
                    balanceHistory.setDescription(expenseRequestBodyDTO.getDescription());
                    balanceHistory.setAmount(-1*contributor.getAmount());
                    balanceHistory.setExpenseCreatedDate(currentDateTime);
                    dost.getBalanceHistoryList().add(balanceHistory);
                }

            });
            payer.getBalanceSheet().getBalanceData().forEach(frndBalance -> {
                if(Objects.equals(frndBalance.getFriendEmail(), contributor.getEmail())){
                    frndBalance.setDelta(frndBalance.getDelta()+ contributor.getAmount());
                    BalanceHistory balanceHistory = new BalanceHistory();
                    balanceHistory.setDescription(expenseRequestBodyDTO.getDescription());
                    balanceHistory.setAmount(contributor.getAmount());
                    balanceHistory.setExpenseCreatedDate(currentDateTime);
                    frndBalance.getBalanceHistoryList().add(balanceHistory);
                }
                personRepository.save(frnd);
            });
        });
        payer.getBalanceSheet().addOweAmount(expenseRequestBodyDTO.getTotalAmt()-payerContribution.get());
        payer.getBalanceSheet().setTotalAmountPaid(expenseRequestBodyDTO.getTotalAmt());

    }


    public String addExpense(ExpenseRequestBodyDTO expenseRequestBodyDTO) {
        Person payer = personRepository.findByEmail(expenseRequestBodyDTO.getPaidBy()).get();
        System.out.println("person ===> " + payer);
        System.out.println("expenseRequestBodyDTO ===> " + expenseRequestBodyDTO);
        LocalDateTime currentDateTime = LocalDateTime.now();
        if (expenseRequestBodyDTO.getSplitType().equalsIgnoreCase("EQUAL")) {
            System.out.println("==EQUAL==");
            handleEqualExpense(expenseRequestBodyDTO, payer, currentDateTime);
        }
        else if (expenseRequestBodyDTO.getSplitType().equalsIgnoreCase("MANUAL"))
                handleManualExpense(expenseRequestBodyDTO,payer,currentDateTime);
        return "SUCCESS";
    }



}
