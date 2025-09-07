package com.powerup.r2dbc.loanapplication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "loan_application")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplicationEntity {

    @Column("id_loan_application")
    private Long idLoanApplication;

    private String email;

    @Column("id_loan_type")
    private Long idLoanType;

    private BigDecimal amount;
    private Integer term;

    @Column("application_date")
    private LocalDateTime applicationDate;

    @Column("id_loan_status")
    private Long idLoanStatus;

    @Column("status_change_date")
    private LocalDateTime statusChangeDate;

}
