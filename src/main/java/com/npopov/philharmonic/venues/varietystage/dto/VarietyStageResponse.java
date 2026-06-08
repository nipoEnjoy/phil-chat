package com.npopov.philharmonic.venues.varietystage.dto;

import com.npopov.philharmonic.venues.venue.dto.VenueResponse;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class VarietyStageResponse extends VenueResponse {

    @Size(max = 100, message = "Genre focus should not exceed 100 symbols")
    private String genreFocus;

    public VarietyStageResponse() {
    }

    public VarietyStageResponse(Long id, String name, String address, String city, String description, LocalDateTime createdAt, LocalDateTime updatedAt, String genreFocus) {
        super(id, name, address, city, description, createdAt, updatedAt);
        this.genreFocus = genreFocus;
    }

    public String getGenreFocus() {
        return genreFocus;
    }

    public void setGenreFocus(String genreFocus) {
        this.genreFocus = genreFocus;
    }
}
