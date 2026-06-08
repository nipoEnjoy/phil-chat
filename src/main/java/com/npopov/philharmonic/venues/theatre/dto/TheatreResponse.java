package com.npopov.philharmonic.venues.theatre.dto;

import com.npopov.philharmonic.venues.venue.dto.VenueResponse;

import java.time.LocalDateTime;

public class TheatreResponse extends VenueResponse {

    private Integer capacity;
    private Integer stageWidthMm;
    private Integer stageDepthMm;

    public TheatreResponse() {
    }

    public TheatreResponse(Long id, String name, String address, String city, String description, LocalDateTime createdAt, LocalDateTime updatedAt, Integer capacity, Integer stageWidthMm, Integer stageDepthMm) {
        super(id, name, address, city, description, createdAt, updatedAt);
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
