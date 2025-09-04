package com.powerup.r2dbc.loantype;

import com.powerup.model.loantype.LoanType;
import com.powerup.model.loantype.gateways.LoanTypeRepository;
import com.powerup.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.reactive.TransactionalOperator;
import reactor.core.publisher.Mono;

/**
 * Repository adapter for LoanType, implementing the LoanTypeRepository interface.
 * This class extends ReactiveAdapterOperations to provide reactive CRUD operations
 * and mapping between domain and entity models.
 *
 * @version 1.0
 * @since 2025-09-04
 */
@Repository
public class LoanTypeReactiveRepositoryAdapter extends ReactiveAdapterOperations<
        LoanType,
        LoanTypeEntity,
        Long,
        LoanTypeReactiveRepository
        > implements LoanTypeRepository {

    private final TransactionalOperator transactionalOperator;

    public LoanTypeReactiveRepositoryAdapter(LoanTypeReactiveRepository repository, ObjectMapper mapper, TransactionalOperator transactionalOperator) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, LoanType.class));
        this.transactionalOperator = transactionalOperator;
    }

    @Override
    public Mono<LoanType> getLoanTypeById(Long idLoanType) {
        return repository.findById(idLoanType)
                .map(loanTypeEntity -> mapper.map(loanTypeEntity, LoanType.class));
    }
}
