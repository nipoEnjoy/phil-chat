package com.npopov.philharmonic.venues.theatre.dto;

import com.npopov.philharmonic.venues.venue.domain.VenueType;
import com.npopov.philharmonic.venues.venue.dto.VenueCreateRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TheatreCreateRequest extends VenueCreateRequest {

    @NotNull(message = "Screen width cannot be null")
    @Positive(message = "Screen width should be a positive number")
    private Integer capacity;

    @Positive(message = "Stage width should be a positive number")
    private Integer stageWidthMm;

    @Positive(message = "Stage depth should be a positive number")
    private Integer stageDepthMm;

    public TheatreCreateRequest() {
    }

    public TheatreCreateRequest(String name, String address, String city, String description, Integer capacity, Integer stageWidthMm, Integer stageDepthMm) {
        super(name, address, city, description);
        this.capacity = capacity;
        this.stageWidthMm = stageWidthMm;
        this.stageDepthMm = stageDepthMm;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getStageWidthMm() {
        return stageWidthMm;
    }

    public void setStageWidthMm(Integer stageWidthMm) {
        this.stageWidthMm = stageWidthMm;
    }

    public Integer getStageDepthMm() {
        return stageDepthMm;
    }

    public void setStageDepthMm(Integer stageDepthMm) {
        this.stageDepthMm = stageDepthMm;
    }
}
