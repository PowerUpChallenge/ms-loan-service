package com.powerup.model.loantype;

import java.math.BigDecimal;

/**
 * LoanType class represents a loan type model
 * It includes fields such as idLoanType, name, minAmount, maxAmount, interestRate, and autoValidation.
 *
 * @version 1.0
 * @since 2025-09-01
 */
public class LoanType {

    private Long idLoanType;
    private String name;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private BigDecimal interestRate;
    private Integer autoValidation;

    public LoanType() {
    }

    public LoanType(Long idLoanType, String name, BigDecimal minAmount, BigDecimal maxAmount, BigDecimal interestRate, Integer autoValidation) {
        this.idLoanType = idLoanType;
        this.name = name;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.interestRate = interestRate;
        this.autoValidation = autoValidation;
    }

    public Long getIdLoanType() {
        return idLoanType;
    }

    public void setIdLoanType(Long idLoanType) {
        this.idLoanType = idLoanType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getAutoValidation() {
        return autoValidation;
    }

    public void setAutoValidation(Integer autoValidation) {
        this.autoValidation = autoValidation;
    }
}
