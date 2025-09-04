package com.powerup.model.loanapplication;

/**
 * LoanApplication class represents a loan application model
 * It includes fields such as idLoanApplication, email, idLoanType, amount, term, and idLoanStatus.
 *
 * @version 1.0
 * @since 2025-09-01
 */
public class LoanApplication {

    private Long idLoanApplication;
    private String email;
    private String idNumber;
    private Long idLoanType;
    private String amount;
    private Integer term;
    private Long idLoanStatus;

    public LoanApplication() {
    }

    public LoanApplication(Long idLoanApplication, String email, String idNumber, Long idLoanType, String amount, Integer term, Long idLoanStatus) {
        this.idLoanApplication = idLoanApplication;
        this.email = email;
        this.idNumber = idNumber;
        this.idLoanType = idLoanType;
        this.amount = amount;
        this.term = term;
        this.idLoanStatus = idLoanStatus;
    }

    public Long getIdLoanApplication() {
        return idLoanApplication;
    }

    public void setIdLoanApplication(Long idLoanApplication) {
        this.idLoanApplication = idLoanApplication;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdLoanType() {
        return idLoanType;
    }

    public void setIdLoanType(Long idLoanType) {
        this.idLoanType = idLoanType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Long getIdLoanStatus() {
        return idLoanStatus;
    }

    public void setIdLoanStatus(Long idLoanStatus) {
        this.idLoanStatus = idLoanStatus;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
