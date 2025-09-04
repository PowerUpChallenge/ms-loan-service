package com.powerup.r2dbc.loanapplication;

import com.powerup.model.loanapplication.LoanApplication;
import com.powerup.model.loanapplication.gateways.LoanApplicationRepository;
import com.powerup.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.reactive.TransactionalOperator;
import reactor.core.publisher.Mono;

/**
 * Adapter implementation for LoanApplicationRepository using R2DBC.
 * Extends ReactiveAdapterOperations to provide reactive CRUD operations.
 * Maps between LoanApplication domain model and LoanApplicationEntity database entity.
 *
 * @version 1.0
 * @since 2025-09-04
 */
@Repository
public class LoanApplicationReactiveRepositoryAdapter extends ReactiveAdapterOperations<
        LoanApplication/* change for domain model */,
        LoanApplicationEntity/* change for adapter model */,
        Long,
        LoanApplicationReactiveRepository
        > implements LoanApplicationRepository {

    private final TransactionalOperator transactionalOperator;

    public LoanApplicationReactiveRepositoryAdapter(LoanApplicationReactiveRepository repository, ObjectMapper mapper, TransactionalOperator transactionalOperator) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, LoanApplication.class/* change for domain model */));
        this.transactionalOperator = transactionalOperator;
    }

    @Override
    public Mono<LoanApplication> saveLoanApplication(LoanApplication entity) {
        return Mono.defer(() -> {
                    LoanApplicationEntity dbEntity = mapper.map(entity, LoanApplicationEntity.class);
                    return repository.save(dbEntity);
                })
                .map(savedEntity -> mapper.map(savedEntity, LoanApplication.class))
                .as(transactionalOperator::transactional);
    }
}
