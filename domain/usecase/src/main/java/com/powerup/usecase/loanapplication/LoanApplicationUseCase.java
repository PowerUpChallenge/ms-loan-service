package com.powerup.usecase.loanapplication;

import com.powerup.exceptions.LoanTypeNotFoundException;
import com.powerup.exceptions.UnauthorizedUserException;
import com.powerup.exceptions.UserAuthNotFoundException;
import com.powerup.model.loanapplication.LoanApplication;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

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

    private static final String ERROR_LOAN_TYPE_NOT_FOUND = "Loan type not found";
    private static final String ERROR_USER_NOT_FOUND = "User not found";
    private static final Long PENDING_STATUS_ID = 1L;

    public LoanApplicationUseCase(com.powerup.model.loanapplication.gateways.LoanApplicationRepository loanApplicationRepository,
                                  com.powerup.model.loantype.gateways.LoanTypeRepository loanTypeRepository,
                                  com.powerup.model.userauth.gateways.UserAuthRepository authRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
        this.loanTypeRepository = loanTypeRepository;
        this.authRepository = authRepository;
    }

    /**
     * Saves a loan application after validating the loan type and user existence.
     *
     * @param loanApplication The loan application to be saved.
     * @return A Mono emitting the saved LoanApplication or an error if validation fails.
     */
//    public Mono<LoanApplication> saveLoanApplication(LoanApplication loanApplication) {
//        return loanTypeRepository.getLoanTypeById(loanApplication.getIdLoanType())
//                .switchIfEmpty(Mono.error(new LoanTypeNotFoundException(ERROR_LOAN_TYPE_NOT_FOUND)))
//                .flatMap(loanType ->
//                        authRepository.findByIdNumber(loanApplication.getIdNumber())
//                                .switchIfEmpty(Mono.error(new UserAuthNotFoundException(ERROR_USER_NOT_FOUND)))
//                                .flatMap(user -> {
//                                    loanApplication.setEmail(user.getEmail());
//                                    loanApplication.setIdLoanStatus(PENDING_STATUS_ID);
//                                    loanApplication.setApplicationDate(LocalDateTime.now());
//                                    return loanApplicationRepository.saveLoanApplication(loanApplication);
//                                })
//                );
//    }

    public Mono<LoanApplication> saveLoanApplication(LoanApplication loanApplication, String tokenUserId) {
        return loanTypeRepository.getLoanTypeById(loanApplication.getIdLoanType())
                .switchIfEmpty(Mono.error(new LoanTypeNotFoundException(ERROR_LOAN_TYPE_NOT_FOUND)))
                .flatMap(loanType ->
                        authRepository.findByIdNumber(loanApplication.getIdNumber())
                                .switchIfEmpty(Mono.error(new UserAuthNotFoundException(ERROR_USER_NOT_FOUND)))
                                .flatMap(user -> {
                                    if (!tokenUserId.equals(String.valueOf(user.getUserId()))) {
                                        return Mono.error(new UnauthorizedUserException(
                                                "The authenticated user does not match the one in the request."));
                                    }
                                    loanApplication.setEmail(user.getEmail());
                                    loanApplication.setIdLoanStatus(PENDING_STATUS_ID);
                                    loanApplication.setApplicationDate(LocalDateTime.now());

                                    return loanApplicationRepository.saveLoanApplication(loanApplication);
                                })
                );
    }

}
