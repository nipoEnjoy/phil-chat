package com.npopov.philharmonic.event.dto;

import com.npopov.philharmonic.event.domain.EventType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record EventUpdateRequest(
        @NotBlank(message = "Event title cannot be blank")
        @Size(max = 200, message = "Title must not exceed 200 characters")
        String title,

        EventType eventType,

        @NotNull(message = "Venue ID is required")
        Long venueId,

        Long organizerId,

        @NotNull(message = "Start datetime is required")
        @Future(message = "Start datetime must be in the future")
        LocalDateTime startDatetime,

        LocalDateTime endDatetime,

        @Size(max = 1000, message = "Description must not exceed 1000 characters")
        String description
) {}