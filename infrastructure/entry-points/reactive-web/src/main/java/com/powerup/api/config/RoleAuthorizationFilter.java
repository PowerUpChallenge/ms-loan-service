package com.powerup.api.config;

import com.powerup.api.exceptions.ForbiddenException;
import com.powerup.model.security.gateway.JwtProvider;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerFilterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class RoleAuthorizationFilter {

    private final JwtProvider jwtProvider;

    public RoleAuthorizationFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    public HandlerFilterFunction<ServerResponse, ServerResponse> requireRole(String role) {
        return (request, next) -> Mono.deferContextual(ctx -> {
            String token = ctx.get("authToken");
            return jwtProvider.getRoles(token)
                    .flatMap(roles -> {
                        if (roles.contains(role)) {
                            return next.handle(request);
                        } else {
                            return Mono.error(new ForbiddenException("Acceso denegado para rol: " + role));
                        }
                    });
        });
    }

}
