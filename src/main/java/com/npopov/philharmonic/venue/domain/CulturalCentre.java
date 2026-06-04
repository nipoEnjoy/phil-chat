package com.npopov.philharmonic.venue.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "cultural_centre")
@PrimaryKeyJoinColumn(name = "id")
public class CulturalCentre extends Venue {

    @Column(name = "community_rooms_count")
    private Integer communityRoomsCount;

    public CulturalCentre() {}

    public CulturalCentre(String name, VenueType venueType, String address, String city, String description, Integer communityRoomsCount) {
        super(name, venueType, address, city, description);
        this.communityRoomsCount = communityRoomsCount;
    }

    public Integer getCommunityRoomsCount() {
        return communityRoomsCount;
    }

    public void setCommunityRoomsCount(Integer communityRoomsCount) {
        this.communityRoomsCount = communityRoomsCount;
    }
}