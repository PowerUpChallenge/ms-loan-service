package com.powerup.api.util;

/**
 * LogMessages is a utility class that holds constant log message templates
 * used throughout the application for consistent logging.
 *
 * @version 1.0
 * @since 2025-09-04
 */
public class LogMessages {

    public static final String LOAN_APPLICATION_START = "Endpoint: {} | Action: Save loan | Starting loan save";
    public static final String LOAN_APPLICATION_DATA = "Endpoint: {} | Action: Save loan | Received data: {}";
    public static final String LOAN_APPLICATION_SUCCESS = "[Endpoint: {} | Action: Save loan | User saved successfully.";
    public static final String LOAN_APPLICATION_ERROR = "Endpoint: {} | Action: Save loan | Error saving loan, cause: {}";

    private LogMessages() {
    }
}