package com.splitprice.project.Service;

import com.splitprice.project.dto.ExpenseRequestBodyDTO;
import org.springframework.stereotype.Service;

@Service
public interface ExpenseService {

    String addExpense(ExpenseRequestBodyDTO expenseDTO);

}
