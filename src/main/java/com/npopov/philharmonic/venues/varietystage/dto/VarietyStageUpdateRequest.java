package com.npopov.philharmonic.venues.varietystage.dto;

import com.npopov.philharmonic.venues.venue.domain.VenueType;
import com.npopov.philharmonic.venues.venue.dto.VenueCreateRequest;

public class VarietyStageUpdateRequest extends VenueCreateRequest {

    private String genreFocus;

    public VarietyStageUpdateRequest() {
    }

    public VarietyStageUpdateRequest(String name, VenueType venueType, String address, String city, String description, String genreFocus) {
        super(name, venueType, address, city, description);
        this.genreFocus = genreFocus;
    }

    public String getGenreFocus() {
        return genreFocus;
    }

    public void setGenreFocus(String genreFocus) {
        this.genreFocus = genreFocus;
    }
}
