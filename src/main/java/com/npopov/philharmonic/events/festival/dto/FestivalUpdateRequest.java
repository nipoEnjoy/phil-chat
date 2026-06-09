package com.npopov.philharmonic.events.festival.dto;

import com.npopov.philharmonic.events.event.dto.EventCreateRequest;
import com.npopov.philharmonic.events.event.dto.EventUpdateRequest;

import java.time.LocalDateTime;

public class FestivalUpdateRequest extends EventUpdateRequest {

    public FestivalUpdateRequest(String title, Long venueId, Long organizerId, LocalDateTime startDatetime, LocalDateTime endDatetime, String description) {
        super(title, venueId, organizerId, startDatetime, endDatetime, description);
    }

    public FestivalUpdateRequest() {
    }
}