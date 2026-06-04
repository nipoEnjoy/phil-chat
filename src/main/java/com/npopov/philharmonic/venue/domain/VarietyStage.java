package com.npopov.philharmonic.venue.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "variety_stage")
@PrimaryKeyJoinColumn(name = "id")
public class VarietyStage extends Venue {

    @Column(name = "genre_focus")
    private String genreFocus;

    public VarietyStage() {}

    public VarietyStage(String name, VenueType venueType, String address, String city, String description, String genreFocus) {
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