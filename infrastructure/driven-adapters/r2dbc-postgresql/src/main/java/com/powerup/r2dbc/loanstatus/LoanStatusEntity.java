package com.powerup.r2dbc.loanstatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "loan_status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanStatusEntity {

    @Column("id_loan_status")
    private Long idLoanStatus;

    private String name;

    private String description;

}
