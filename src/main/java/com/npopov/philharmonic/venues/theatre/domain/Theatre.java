package com.npopov.philharmonic.venues.theatre.domain;

import com.npopov.philharmonic.venues.venue.domain.Venue;
import com.npopov.philharmonic.venues.venue.domain.VenueType;
import jakarta.persistence.*;

@Entity
@Table(name = "theatre")
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("THEATRE")
public class Theatre extends Venue {

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "stage_width_mm")
    private Integer stageWidthMm;

    @Column(name = "stage_depth_mm")
    private Integer stageDepthMm;

    public Theatre() {}

    public Theatre(String name, String address, String city, String description, Integer capacity, Integer stageWidthMm, Integer stageDepthMm) {
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