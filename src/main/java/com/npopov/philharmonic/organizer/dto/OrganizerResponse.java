package com.npopov.philharmonic.organizer.dto;

import java.time.LocalDateTime;

public record OrganizerResponse(
        Long id,
        String name,
        String contactInfo,
        String type,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}