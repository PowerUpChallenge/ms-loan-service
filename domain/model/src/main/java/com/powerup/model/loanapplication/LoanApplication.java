package com.powerup.model.loanapplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    private BigDecimal amount;
    private Integer term;
    private LocalDateTime applicationDate;
    private Long idLoanStatus;
    private LocalDateTime statusChangeDate;

    public LoanApplication() {
    }

    public LoanApplication(Long idLoanApplication, String email, String idNumber, Long idLoanType, BigDecimal amount, Integer term, LocalDateTime applicationDate, Long idLoanStatus, LocalDateTime statusChangeDate) {
        this.idLoanApplication = idLoanApplication;
        this.email = email;
        this.idNumber = idNumber;
        this.idLoanType = idLoanType;
        this.amount = amount;
        this.term = term;
        this.applicationDate = applicationDate;
        this.idLoanStatus = idLoanStatus;
        this.statusChangeDate = statusChangeDate;
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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Long getIdLoanType() {
        return idLoanType;
    }

    public void setIdLoanType(Long idLoanType) {
        this.idLoanType = idLoanType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Long getIdLoanStatus() {
        return idLoanStatus;
    }

    public void setIdLoanStatus(Long idLoanStatus) {
        this.idLoanStatus = idLoanStatus;
    }

    public LocalDateTime getStatusChangeDate() {
        return statusChangeDate;
    }

    public void setStatusChangeDate(LocalDateTime statusChangeDate) {
        this.statusChangeDate = statusChangeDate;
    }
}
