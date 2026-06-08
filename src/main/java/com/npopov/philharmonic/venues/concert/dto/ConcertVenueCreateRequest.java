package com.npopov.philharmonic.venues.concert.dto;

import com.npopov.philharmonic.venues.venue.domain.VenueType;
import com.npopov.philharmonic.venues.venue.dto.VenueCreateRequest;
import jakarta.validation.constraints.Size;
import jdk.jfr.BooleanFlag;

public class ConcertVenueCreateRequest extends VenueCreateRequest {

    @Size(max = 50, message = "Stage type must not exceed 50 characters")
    private String stageType;

    @BooleanFlag
    private Boolean hasSoundSystem;

    public ConcertVenueCreateRequest() {}

    public ConcertVenueCreateRequest(String name, VenueType venueType, String address, String city, String description, String stageType, Boolean hasSoundSystem) {
        super(name, venueType, address, city, description);
        this.stageType = stageType;
        this.hasSoundSystem = hasSoundSystem;
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
