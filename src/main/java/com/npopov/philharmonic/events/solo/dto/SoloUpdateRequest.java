package com.npopov.philharmonic.events.solo.dto;

import com.npopov.philharmonic.events.event.dto.EventCreateRequest;
import com.npopov.philharmonic.events.event.dto.EventUpdateRequest;

import java.time.LocalDateTime;

public class SoloUpdateRequest extends EventUpdateRequest {

    public SoloUpdateRequest() {
    }

    public SoloUpdateRequest(String title, Long venueId, Long organizerId, LocalDateTime startDatetime, LocalDateTime endDatetime, String description) {
        super(title, venueId, organizerId, startDatetime, endDatetime, description);
    }
}