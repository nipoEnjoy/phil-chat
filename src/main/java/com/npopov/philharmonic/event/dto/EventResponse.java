package com.npopov.philharmonic.event.dto;

import com.npopov.philharmonic.event.domain.EventType;
import com.npopov.philharmonic.organizer.dto.OrganizerResponse;
import com.npopov.philharmonic.venue.dto.VenueResponse;

import java.time.LocalDateTime;

public record EventResponse(
        Long id,
        String title,
        EventType eventType,
        Long venueId,
        Long organizerId,
        LocalDateTime startDatetime,
        LocalDateTime endDatetime,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}