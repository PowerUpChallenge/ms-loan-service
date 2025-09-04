package com.powerup.exceptions;

/**
 * Exception thrown when a user is not found in the system.
 *
 * @version 1.0
 * @since 2025-09-03
 */
public class UserAuthNotFoundException extends RuntimeException {
    public UserAuthNotFoundException(String message) {
        super(message);
    }
}
