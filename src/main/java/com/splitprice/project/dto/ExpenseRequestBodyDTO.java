package com.splitprice.project.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class ExpenseRequestBodyDTO {

    @Email(message = "Enter valid email format")
    String paidBy;

    @Min(value = 0, message = "Enter positive(+ve) value")
    Double totalAmt;

    @Size(min = 1, max = 50, message = "No Description")
    String description;

    @Pattern(regexp = "^(EQUAL|MANUAL|PERCENTAGE)$", message = "split type must be EQUAL|MANUAL|PERCENTAGE")
    String splitType;

    @Size(min = 1, message = "No Contributors")
    List<contributorDTO> contributors;
}
