package com.powerup.model.loanapplication.gateways;

import reactor.core.publisher.Mono;
import com.powerup.model.loanapplication.LoanApplication;

/**
 * LoanApplicationRepository interface defines the contract for saving loan applications.
 * It includes a method to save a LoanApplication object and returns a Mono of the saved object.
 *
 * @version 1.0
 * @since 2025-09-01
 */
public interface LoanApplicationRepository {

    /**
     * Save a new loan application.
     *
     * @param loanApplication The loan application to be saved.
     * @return A Mono emitting the saved LoanApplication.
     */
    Mono<LoanApplication> saveLoanApplication(LoanApplication loanApplication);

}
