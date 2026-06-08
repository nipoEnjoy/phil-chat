package com.npopov.philharmonic.venues.culturalcentre.dto;

import com.npopov.philharmonic.venues.concert.domain.ConcertVenue;
import com.npopov.philharmonic.venues.concert.dto.ConcertVenueResponse;
import com.npopov.philharmonic.venues.culturalcentre.domain.CulturalCentre;
import org.springframework.stereotype.Component;

@Component
public class CulturalCentreMapper {

    public CulturalCentre toCulturalCentreFromCreate(CulturalCentreCreateRequest request) {
        return new  CulturalCentre(
                request.getName(),
                request.getAddress(),
                request.getCity(),
                request.getDescription(),
                request.getCommunityRoomsCount()
        );
    }

    public CulturalCentre toCulturalCentreFromUpdate(CulturalCentreUpdateRequest request) {
        return new  CulturalCentre(
                request.getName(),
                request.getAddress(),
                request.getCity(),
                request.getDescription(),
                request.getCommunityRoomsCount()
        );
    }

    public CulturalCentreResponse toResponse(CulturalCentre culturalCentre) {
        return new CulturalCentreResponse(
                culturalCentre.getId(),
                culturalCentre.getName(),
                culturalCentre.getAddress(),
                culturalCentre.getCity(),
                culturalCentre.getDescription(),
                culturalCentre.getCreatedAt(),
                culturalCentre.getUpdatedAt(),
                culturalCentre.getCommunityRoomsCount()
        );
    }
}