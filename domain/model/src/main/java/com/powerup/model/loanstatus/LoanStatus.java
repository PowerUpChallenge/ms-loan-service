package com.powerup.model.loanstatus;

/**
 * LoanStatus class represents a loan status model
 * It includes fields such as idLoanStatus, name, and description.
 *
 * @version 1.0
 * @since 2025-09-01
 */
public class LoanStatus {

    private Long idLoanStatus;
    private String name;
    private String description;

    public LoanStatus() {
    }

    public LoanStatus(Long idLoanStatus, String name, String description) {
        this.idLoanStatus = idLoanStatus;
        this.name = name;
        this.description = description;
    }

    public Long getIdLoanStatus() {
        return idLoanStatus;
    }

    public void setIdLoanStatus(Long idLoanStatus) {
        this.idLoanStatus = idLoanStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
