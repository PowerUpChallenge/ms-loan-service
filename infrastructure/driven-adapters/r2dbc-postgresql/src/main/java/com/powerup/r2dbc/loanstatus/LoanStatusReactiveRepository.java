package com.powerup.r2dbc.loanstatus;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * Reactive repository interface for LoanStatusEntity.
 * Extends ReactiveCrudRepository for basic CRUD operations
 * and ReactiveQueryByExampleExecutor for query by example functionality.
 *
 * @version 1.0
 * @since 2025-09-04
 */
public interface LoanStatusReactiveRepository extends
        ReactiveCrudRepository<LoanStatusEntity, Long>, ReactiveQueryByExampleExecutor<LoanStatusEntity> {

}
