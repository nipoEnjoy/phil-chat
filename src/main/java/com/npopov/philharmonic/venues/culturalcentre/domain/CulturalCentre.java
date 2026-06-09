package com.npopov.philharmonic.venues.culturalcentre.domain;

import com.npopov.philharmonic.venues.venue.domain.Venue;
import com.npopov.philharmonic.venues.venue.domain.VenueType;
import jakarta.persistence.*;

@Entity
@Table(name = "cultural_centre")
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("CULTURAL_CENTRE")
public class CulturalCentre extends Venue {

    @Column(name = "community_rooms_count")
    private Integer communityRoomsCount;

    public CulturalCentre() {}

    public CulturalCentre(String name, String address, String city, String description, Integer communityRoomsCount) {
        super(name, address, city, description);
        this.communityRoomsCount = communityRoomsCount;
    }

    public Integer getCommunityRoomsCount() {
        return communityRoomsCount;
    }

    public void setCommunityRoomsCount(Integer communityRoomsCount) {
        this.communityRoomsCount = communityRoomsCount;
    }
}