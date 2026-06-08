package com.npopov.philharmonic.venues.concert.dto;

import com.npopov.philharmonic.venues.venue.dto.VenueResponse;

import java.time.LocalDateTime;

public class ConcertVenueResponse extends VenueResponse {

    private String stageType;
    private Boolean hasSoundSystem;

    public ConcertVenueResponse(Long id, String name, String address, String city, String description, LocalDateTime createdAt, LocalDateTime updatedAt, String stageType, Boolean hasSoundSystem) {
        super(id, name, address, city, description, createdAt, updatedAt);
        this.stageType = stageType;
        this.hasSoundSystem = hasSoundSystem;
    }

    public ConcertVenueResponse() {
    }

    public String getStageType() {
        return stageType;
    }

    public void setStageType(String stageType) {
        this.stageType = stageType;
    }

    public Boolean getHasSoundSystem() {
        return hasSoundSystem;
    }

    public void setHasSoundSystem(Boolean hasSoundSystem) {
        this.hasSoundSystem = hasSoundSystem;
    }
}