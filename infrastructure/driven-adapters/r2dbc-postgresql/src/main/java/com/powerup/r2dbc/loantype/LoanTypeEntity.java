package com.powerup.r2dbc.loantype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table(name = "loan_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanTypeEntity {

    @Id
    @Column("id_loan_type")
    private Long idLoanType;
    private String name;

    @Column("min_amount")
    private BigDecimal minAmount;

    @Column("max_amount")
    private BigDecimal maxAmount;

    @Column("interest_rate")
    private BigDecimal interestRate;

    @Column("automatic_validation")
    private Integer autoValidation;

}
