package com.splitprice.project.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class contributorDTO {
    @Email(message="INVLID EMAIL in contributors array")
    String email;

    Double percentage;
    Double amount;
}
