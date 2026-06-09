package com.npopov.philharmonic.venues.varietystage.dto;

import com.npopov.philharmonic.venues.venue.domain.VenueType;
import com.npopov.philharmonic.venues.venue.dto.VenueCreateRequest;

public class VarietyStageCreateRequest extends VenueCreateRequest {

    private String genreFocus;

    public VarietyStageCreateRequest() {
    }

    public VarietyStageCreateRequest(String name, String address, String city, String description, String genreFocus) {
        super(name, address, city, description);
        this.genreFocus = genreFocus;
    }

    public String getGenreFocus() {
        return genreFocus;
    }

    public void setGenreFocus(String genreFocus) {
        this.genreFocus = genreFocus;
    }
}
