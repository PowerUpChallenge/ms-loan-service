package com.powerup.model.loanstatus.gateways;

import reactor.core.publisher.Mono;
import com.powerup.model.loanstatus.LoanStatus;

/**
 * LoanStatusRepository interface defines the contract for retrieving loan statuses.
 * It includes a method to get a LoanStatus by its ID and returns a Mono of the LoanStatus object.
 *
 * @version 1.0
 * @since 2025-09-01
 */
public interface LoanStatusRepository {

    /**
     * Get a loan status by its ID.
     *
     * @param idLoanStatus The ID of the loan status to be retrieved.
     * @return A Mono emitting the LoanStatus with the specified ID.
     */
    Mono<LoanStatus> getById(Long idLoanStatus);

}
