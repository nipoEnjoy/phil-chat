package com.npopov.philharmonic.events.concert.dto;

import com.npopov.philharmonic.events.event.dto.EventResponse;
import com.npopov.philharmonic.events.concert.domain.Concert;

import java.time.LocalDateTime;

public class ConcertResponse extends EventResponse {

    private String program;

    public ConcertResponse(Long id, String title, Long venueId, String venueName, Long organizerId, String organizerName, LocalDateTime startDatetime, LocalDateTime endDatetime, String description, LocalDateTime createdAt, LocalDateTime updatedAt, String program) {
        super(id, title, venueId, venueName, organizerId, organizerName, startDatetime, endDatetime, description, createdAt, updatedAt);
        this.program = program;
    }

    public String getProgram() { return program; }
    public void setProgram(String program) { this.program = program; }
}