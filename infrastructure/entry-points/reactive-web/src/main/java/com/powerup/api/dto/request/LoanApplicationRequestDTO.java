package com.powerup.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class LoanApplicationRequestDTO {

    private String idNumber;
    private Long idLoanType;
    private String amount;
    private Integer term;

}
