package com.powerup.model.security.gateway;

import reactor.core.publisher.Mono;

import java.util.Set;

public interface JwtProvider {

    Mono<Boolean> validate(String token);
    Mono<String> getUsername(String token);
    Mono<Set<String>> getRoles(String token);

}
