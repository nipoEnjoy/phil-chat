package com.npopov.philharmonic.venues.culturalcentre.dto;

import com.npopov.philharmonic.venues.venue.domain.VenueType;
import com.npopov.philharmonic.venues.venue.dto.VenueCreateRequest;
import com.npopov.philharmonic.venues.venue.dto.VenueUpdateRequest;
import jakarta.validation.constraints.Positive;

public class CulturalCentreUpdateRequest extends VenueUpdateRequest {

    @Positive(message = "Community rooms count should be a positive number")
    private Integer communityRoomsCount;

    public CulturalCentreUpdateRequest() {
    }

    public CulturalCentreUpdateRequest(String name, String address, String city, String description, Integer communityRoomsCount) {
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
