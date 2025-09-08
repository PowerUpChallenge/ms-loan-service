package com.powerup.api.exceptions;

/**
 * Exception thrown when a loan type is not found in the system.
 *
 * @version 1.0
 * @since 2025-09-03
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
