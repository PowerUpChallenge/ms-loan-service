package com.powerup.usecase.loanapplication;

import com.powerup.model.loanapplication.LoanApplication;
import reactor.core.publisher.Mono;

/**
 * LoanApplicationUseCase class handles the business logic for loan applications.
 * It interacts with repositories for loan applications, loan types, and user authentication.
 * The main functionality includes saving a loan application after validating the loan type and user existence.
 *
 * @version 1.0
 * @since 2025-09-03
 */
public class LoanApplicationUseCase {

    private final com.powerup.model.loanapplication.gateways.LoanApplicationRepository loanApplicationRepository;
    private final com.powerup.model.loantype.gateways.LoanTypeRepository loanTypeRepository;
    private final com.powerup.model.userauth.gateways.UserAuthRepository authRepository;

    private static final Long PENDING_STATUS_ID = 1L;

    public LoanApplicationUseCase(com.powerup.model.loanapplication.gateways.LoanApplicationRepository loanApplicationRepository,
                                  com.powerup.model.loantype.gateways.LoanTypeRepository loanTypeRepository,
                                  com.powerup.model.userauth.gateways.UserAuthRepository authRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
        this.loanTypeRepository = loanTypeRepository;
        this.authRepository = authRepository;
    }

    public Mono<LoanApplication> saveLoanApplication(LoanApplication loanApplication) {
        return loanTypeRepository.getLoanTypeById(loanApplication.getIdLoanType())
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Loan type not found")))
                .flatMap(loanType ->
                        authRepository.findByIdNumber(loanApplication.getIdNumber())
                                .switchIfEmpty(Mono.error(new IllegalArgumentException("Document not found in ms-auth-service")))
                                .flatMap(user -> {
                                    loanApplication.setEmail(user.getEmail());
                                    loanApplication.setIdLoanStatus(PENDING_STATUS_ID);
                                    return loanApplicationRepository.save(loanApplication);
                                })
                );
    }
}
