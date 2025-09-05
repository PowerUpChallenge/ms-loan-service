package com.powerup.api.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LoanApplicationResponseDTO {

    private String email;
    private Long idLoanType;
    private String amount;
    private Integer term;
    private LocalDateTime applicationDate;

}
