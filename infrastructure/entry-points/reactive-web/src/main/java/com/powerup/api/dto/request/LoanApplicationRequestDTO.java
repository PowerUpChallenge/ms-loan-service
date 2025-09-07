package com.powerup.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanApplicationRequestDTO {

    private String idNumber;
    private Long idLoanType;
    private BigDecimal amount;
    private Integer term;

}
