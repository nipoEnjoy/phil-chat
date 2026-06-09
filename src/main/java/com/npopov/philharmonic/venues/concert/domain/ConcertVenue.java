package com.npopov.philharmonic.venues.concert.domain;

import com.npopov.philharmonic.venues.venue.domain.Venue;
import com.npopov.philharmonic.venues.venue.domain.VenueType;
import jakarta.persistence.*;

@Entity
@Table(name = "concert_venue")
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("CONCERT_VENUE")
public class ConcertVenue extends Venue {

    @Column(name = "stage_type")
    private String stageType;

    @Column(name = "has_sound_system")
    private Boolean hasSoundSystem;

    public ConcertVenue() {}

    public ConcertVenue(String name, String address, String city, String description, String stageType, Boolean hasSoundSystem) {
        super(name, address, city, description);
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