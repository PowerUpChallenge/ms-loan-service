package com.powerup.api.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class LoanApplicationResponseDTO {

    private Long userId;
    private String email;
    private Long idLoanType;
    private String amount;
    private Integer term;
    private LocalDateTime applicationDate;

}
