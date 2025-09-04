package com.powerup.usecase.loanstatus;

import com.powerup.model.loanstatus.LoanStatus;

/**
 * Use case class for managing LoanStatus entities.
 * Provides methods for retrieving loan statuses.
 * Uses reactive type Mono for asynchronous operations.
 *
 * @version 1.0
 * @since 2025-09-01
 */
public class LoanStatusUseCase {

    private final com.powerup.model.loanstatus.gateways.LoanStatusRepository loanStatusRepository;

    public LoanStatusUseCase(com.powerup.model.loanstatus.gateways.LoanStatusRepository loanStatusRepository) {
        this.loanStatusRepository = loanStatusRepository;
    }

    /**
     * Retrieve a loan status by its ID.
     *
     * @param id The ID of the loan status.
     * @return A Mono emitting the loan status if found, or empty if not found.
     */
    public reactor.core.publisher.Mono<LoanStatus> getLoanStatusById(Long id) {
        return loanStatusRepository.getLoanStatusById(id);
    }
}
