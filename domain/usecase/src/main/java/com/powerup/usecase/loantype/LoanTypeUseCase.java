package com.powerup.usecase.loantype;


import com.powerup.model.loantype.LoanType;
import reactor.core.publisher.Mono;

/**
 * Use case class for managing LoanType entities.
 * Provides methods for retrieving loan types.
 * Uses reactive type Mono for asynchronous operations.
 *
 * @version 1.0
 * @since 2025-09-01
 */
public class LoanTypeUseCase {

    private final com.powerup.model.loantype.gateways.LoanTypeRepository loanTypeRepository;

    public LoanTypeUseCase(com.powerup.model.loantype.gateways.LoanTypeRepository loanTypeRepository) {
        this.loanTypeRepository = loanTypeRepository;
    }

    /**
     * Retrieve a loan type by its ID.
     *
     * @param id The ID of the loan type.
     * @return A Mono emitting the loan type if found, or empty if not found.
     */
    public Mono<LoanType> getLoanTypeById(Long id) {
        return loanTypeRepository.getLoanTypeById(id);
    }

}
