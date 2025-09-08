package com.powerup.api.config;

import com.powerup.api.exceptions.UnauthorizedException;
import com.powerup.model.security.gateway.JwtProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class AuthenticationTokenFilter implements WebFilter {

    private final JwtProvider jwtProvider;

    public AuthenticationTokenFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return resolveToken(exchange)
                .switchIfEmpty(Mono.error(new UnauthorizedException("Token ausente")))
                .flatMap(token ->
                        jwtProvider.validate(token)
                                .filter(Boolean::booleanValue)
                                .switchIfEmpty(Mono.error(new UnauthorizedException("Token inválido")))
                                .flatMap(valid ->
                                        jwtProvider.getUsername(token)
                                                .flatMap(userId -> {
                                                    ServerWebExchange mutated = exchange.mutate()
                                                            .request(exchange.getRequest().mutate()
                                                                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                                                                    .build())
                                                            .build();

                                                    // Se settea el token como el userId en el contexto para su uso
                                                    return chain.filter(mutated)
                                                            .contextWrite(ctx -> ctx
                                                                    .put("authToken", token)
                                                                    .put("authUserId", userId)
                                                            );
                                                })
                                )
                );
    }

    private Mono<String> resolveToken(ServerWebExchange exchange) {
        return Mono.justOrEmpty(exchange.getRequest()
                        .getHeaders()
                        .getFirst(HttpHeaders.AUTHORIZATION))
                .filter(authHeader -> authHeader.startsWith("Bearer "))
                .map(authHeader -> authHeader.substring(7));
    }
}