package com.powerup.model.userauth.gateways;

import com.powerup.model.userauth.UserAuth;
import reactor.core.publisher.Mono;

/**
 * UserAuthRepository interface for user authentication data access operations.
 * It defines methods for retrieving user authentication details based on specific criteria.
 *
 * @version 1.0
 * @since 2025-09-03
 */
public interface UserAuthRepository {

    /**
     * Finds a UserAuth by their ID number.
     *
     * @param idNumber the ID number of the user
     * @return a Mono emitting the UserAuth if found, or empty if not found
     */
    Mono<UserAuth> findByIdNumber(String idNumber);

}
