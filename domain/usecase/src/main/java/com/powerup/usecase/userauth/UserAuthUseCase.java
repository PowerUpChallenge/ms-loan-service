package com.powerup.usecase.userauth;

import com.powerup.model.userauth.UserAuth;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * UserAuthUseCase class handles the business logic for user authentication.
 * It interacts with the UserAuthRepository to retrieve user information based on the provided idNumber.
 *
 * @version 1.0
 * @since 2025-09-01
 */
public class UserAuthUseCase {

    private final com.powerup.model.userauth.gateways.UserAuthRepository userAuthRepository;

    public UserAuthUseCase(com.powerup.model.userauth.gateways.UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }

    /**
     * Retrieves a UserAuth object by its idNumber.
     *
     * @param idNumber The idNumber of the user to be retrieved.
     * @return A Mono emitting the UserAuth object if found, or empty if not found.
     */
    Mono<UserAuth> getUserByEmail(String idNumber) {
        return userAuthRepository.findByIdNumber(idNumber);
    }

}
