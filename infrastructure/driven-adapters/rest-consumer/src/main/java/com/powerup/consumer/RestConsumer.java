package com.powerup.consumer;

import com.powerup.consumer.dto.request.UserRequestDTO;
import com.powerup.consumer.dto.response.UserResponseDTO;
import com.powerup.model.userauth.UserAuth;
import com.powerup.model.userauth.gateways.UserAuthRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * RestConsumer is responsible for consuming external RESTful services to manage user authentication.
 * It implements the UserAuthRepository interface to provide methods for retrieving user information
 * based on identification number.
 *
 * @version 1.0
 * @since 2025-09-04
 */
@Service
@RequiredArgsConstructor
public class RestConsumer implements UserAuthRepository{

    private final WebClient client;

    /**
     * Finds a user by their identification number.
     *
     * @param idNumber The identification number of the user.
     * @return A Mono emitting the UserAuth if found, or empty if not found.
     */
    @CircuitBreaker(name = "findUserByIdNumber")
    public Mono<UserAuth> findByIdNumber(String idNumber) {

        UserRequestDTO userRequestDTO = UserRequestDTO.builder()
                .idNumber(idNumber)
                .build();

        return client.post()
                .uri("/api/v1/usuarios")
                .bodyValue(userRequestDTO)
                .retrieve()
                .bodyToMono(UserAuth.class);
    }

}
