package com.npopov.philharmonic.events.solo.dto;

import com.npopov.philharmonic.events.event.dto.EventResponse;

import java.time.LocalDateTime;

public class SoloResponse extends EventResponse {

    public SoloResponse(Long id, String title, Long venueId, String venueName, Long organizerId, String organizerName, LocalDateTime startDatetime, LocalDateTime endDatetime, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(id, title, venueId, venueName, organizerId, organizerName, startDatetime, endDatetime, description, createdAt, updatedAt);
    }

    public SoloResponse() {
    }
}
