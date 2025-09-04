package com.powerup.r2dbc.loanstatus;

import com.powerup.model.loanstatus.LoanStatus;
import com.powerup.model.loanstatus.gateways.LoanStatusRepository;
import com.powerup.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.reactive.TransactionalOperator;
import reactor.core.publisher.Mono;

/**
 * Adapter class for LoanStatus repository operations.
 * Extends ReactiveAdapterOperations to provide CRUD operations
 * and implements LoanStatusRepository for domain-specific methods.
 *
 * @version 1.0
 * @since 2025-09-04
 */
@Repository
public class LoanStatusReactiveRepositoryAdapter extends ReactiveAdapterOperations<
        LoanStatus,
        LoanStatusEntity,
        Long,
        LoanStatusReactiveRepository
        > implements LoanStatusRepository {

    private final TransactionalOperator transactionalOperator;

    public LoanStatusReactiveRepositoryAdapter(LoanStatusReactiveRepository repository, ObjectMapper mapper, TransactionalOperator transactionalOperator) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, LoanStatus.class/* change for domain model */));
        this.transactionalOperator = transactionalOperator;
    }

    @Override
    public Mono<LoanStatus> getLoanStatusById(Long idLoanStatus) {
        return repository.findById(idLoanStatus)
                .map(loanStatusEntity -> mapper.map(loanStatusEntity, LoanStatus.class));
    }
}
