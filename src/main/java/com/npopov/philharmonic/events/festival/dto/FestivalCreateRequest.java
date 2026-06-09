package com.npopov.philharmonic.events.festival.dto;

import com.npopov.philharmonic.events.event.dto.EventCreateRequest;

import java.time.LocalDateTime;

public class FestivalCreateRequest extends EventCreateRequest {

    public FestivalCreateRequest(String title, Long venueId, Long organizerId, LocalDateTime startDatetime, LocalDateTime endDatetime, String description) {
        super(title, venueId, organizerId, startDatetime, endDatetime, description);
    }

    public FestivalCreateRequest() {
    }
}
