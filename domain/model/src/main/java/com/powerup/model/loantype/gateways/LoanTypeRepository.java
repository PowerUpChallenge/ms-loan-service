package com.powerup.model.loantype.gateways;

import reactor.core.publisher.Mono;
import com.powerup.model.loantype.LoanType;

/**
 * LoanTypeRepository interface defines the contract for retrieving loan types.
 * It includes a method to get a LoanType by its ID and returns a Mono of the LoanType object.
 *
 * @version 1.0
 * @since 2025-09-01
 */
public interface LoanTypeRepository {

    /**
     * Get a loan type by its ID.
     *
     * @param idLoanType The ID of the loan type to be retrieved.
     * @return A Mono emitting the LoanType with the specified ID.
     */
    Mono<LoanType> getLoanTypeById(Long idLoanType);

}
