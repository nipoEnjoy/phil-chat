package com.npopov.philharmonic.events.concert.dto;

import com.npopov.philharmonic.events.event.dto.EventCreateRequest;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class ConcertUpdateRequest extends EventCreateRequest {

    @Size(max = 1000)
    private String program;

    public ConcertUpdateRequest() {}

    public ConcertUpdateRequest(String title, Long venueId, Long organizerId, LocalDateTime startDatetime, LocalDateTime endDatetime, String description, String program) {
        super(title, venueId, organizerId, startDatetime, endDatetime, description);
        this.program = program;
    }

    public String getProgram() { return program; }

    public void setProgram(String program) { this.program = program; }
}
