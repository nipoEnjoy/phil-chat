package com.npopov.philharmonic.venues.culturalcentre.dto;

import com.npopov.philharmonic.venues.venue.dto.VenueResponse;

import java.time.LocalDateTime;

public class CulturalCentreResponse extends VenueResponse {

    private Integer communityRoomsCount;

    public CulturalCentreResponse() {
    }

    public CulturalCentreResponse(Long id, String name, String address, String city, String description, LocalDateTime createdAt, LocalDateTime updatedAt, Integer communityRoomsCount) {
        super(id, name, address, city, description, createdAt, updatedAt);
        this.communityRoomsCount = communityRoomsCount;
    }

    public Integer getCommunityRoomsCount() {
        return communityRoomsCount;
    }

    public void setCommunityRoomsCount(Integer communityRoomsCount) {
        this.communityRoomsCount = communityRoomsCount;
    }
}
