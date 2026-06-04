package com.npopov.philharmonic.shared.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponse(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String path,
        List<FieldError> details
) {
    public record FieldError(String field, String message) {}
}