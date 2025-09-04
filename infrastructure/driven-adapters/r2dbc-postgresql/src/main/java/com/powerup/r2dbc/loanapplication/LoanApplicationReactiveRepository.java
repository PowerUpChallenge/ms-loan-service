package com.powerup.r2dbc.loanapplication;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * Reactive Repository for LoanApplication entities.
 * Extends ReactiveCrudRepository for basic CRUD operations
 * and ReactiveQueryByExampleExecutor for query by example functionality.
 *
 * @version 1.0
 * @since 2025-09-04
 */
public interface LoanApplicationReactiveRepository extends
        ReactiveCrudRepository<LoanApplicationEntity, Long>, ReactiveQueryByExampleExecutor<LoanApplicationEntity> {

}
