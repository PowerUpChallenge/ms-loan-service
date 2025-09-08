package com.powerup.jwt;

import com.powerup.model.security.gateway.JwtProvider;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.crypto.SecretKey;
import java.util.Set;

@Component
public class JjwtProviderAdapter implements JwtProvider {

    private final SecretKey secretKey;
    private final long ttlSeconds;
    private static final String ROLES = "roles";

    public JjwtProviderAdapter(@Value("${security.jwt.secret}") String secret,
                               @Value("${security.jwt.ttl-seconds}") long ttl) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
        this.ttlSeconds = ttl;
    }

    @Override
    public Mono<Boolean> validate(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return Mono.just(true);
        } catch (Exception e) {
            return Mono.just(false);
        }
    }

    @Override
    public Mono<String> getUsername(String token) {
        return Mono.fromSupplier(()           -> {
            try {
                return Jwts.parserBuilder()
                        .setSigningKey(secretKey)
                        .build()
                        .parseClaimsJws(token)
                        .getBody()
                        .getSubject();
            } catch (Exception e) {
                return null;
            }
        });
    }

    @Override
    public Mono<Set<String>> getRoles(String token) {
        return Mono.fromSupplier(() -> {
            try {
                Object roles = Jwts.parserBuilder()
                        .setSigningKey(secretKey)
                        .build()
                        .parseClaimsJws(token)
                        .getBody()
                        .get(ROLES);
                if (roles instanceof String) {
                    return Set.of((String) roles);
                } else if (roles instanceof Iterable<?>) {
                    Set<String> rolesSet = new java.util.HashSet<>();
                    for (Object role : (Iterable<?>) roles) {
                        if (role instanceof String) {
                            rolesSet.add((String) role);
                        }
                    }
                    return rolesSet;
                } else {
                    return Set.of();
                }
            } catch (Exception e) {
                return Set.of();
            }
        });
    }
}
