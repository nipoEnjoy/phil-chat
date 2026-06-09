package com.npopov.philharmonic.venues.varietystage.domain;

import com.npopov.philharmonic.venues.venue.domain.Venue;
import com.npopov.philharmonic.venues.venue.domain.VenueType;
import jakarta.persistence.*;

@Entity
@Table(name = "variety_stage")
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("VARIETY_STAGE")
public class VarietyStage extends Venue {

    @Column(name = "genre_focus")
    private String genreFocus;

    public VarietyStage() {}

    public VarietyStage(String name, String address, String city, String description, String genreFocus) {
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