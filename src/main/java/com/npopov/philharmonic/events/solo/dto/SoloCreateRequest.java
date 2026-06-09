package com.npopov.philharmonic.events.solo.dto;

import com.npopov.philharmonic.events.event.dto.EventCreateRequest;

import java.time.LocalDateTime;

public class SoloCreateRequest extends EventCreateRequest {

    public SoloCreateRequest() {
    }

    public SoloCreateRequest(String title, Long venueId, Long organizerId, LocalDateTime startDatetime, LocalDateTime endDatetime, String description) {
        super(title, venueId, organizerId, startDatetime, endDatetime, description);
    }
}