package com.npopov.philharmonic.events.otherevent.dto;

import com.npopov.philharmonic.events.event.dto.EventResponse;

import java.time.LocalDateTime;

public class OtherEventResponse extends EventResponse {

    public OtherEventResponse(Long id, String title, Long venueId, String venueName, Long organizerId, String organizerName, LocalDateTime startDatetime, LocalDateTime endDatetime, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(id, title, venueId, venueName, organizerId, organizerName, startDatetime, endDatetime, description, createdAt, updatedAt);
    }
}
