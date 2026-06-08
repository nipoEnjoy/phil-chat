package com.npopov.philharmonic.venues.culturalcentre.dto;

import com.npopov.philharmonic.venues.venue.domain.VenueType;
import com.npopov.philharmonic.venues.venue.dto.VenueCreateRequest;
import jakarta.validation.constraints.Positive;

public class CulturalCentreCreateRequest extends VenueCreateRequest {

    @Positive(message = "Community rooms count should be a positive number")
    private Integer communityRoomsCount;

    public CulturalCentreCreateRequest() {
    }

    public CulturalCentreCreateRequest(String name, VenueType venueType, String address, String city, String description, Integer communityRoomsCount) {
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
