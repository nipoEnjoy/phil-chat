package com.npopov.philharmonic.impresario.dto;

import java.time.LocalDateTime;

public record ImpresarioResponse(
        Long id,
        String firstName,
        String lastName,
        String organization,
        String contactInfo,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}