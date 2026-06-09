package com.npopov.philharmonic.venues.theatre.dto;

import com.npopov.philharmonic.venues.theatre.domain.Theatre;
import com.npopov.philharmonic.venues.venue.domain.VenueType;
import org.springframework.stereotype.Component;

@Component
public class TheatreMapper {

    public Theatre toTheatreFromCreate(TheatreCreateRequest request) {
        return new  Theatre(
                request.getName(),
                request.getAddress(),
                request.getCity(),
                request.getDescription(),
                request.getCapacity(),
                request.getStageWidthMm(),
                request.getStageDepthMm()
        );
    }

    public Theatre toTheatreFromUpdate(TheatreUpdateRequest request) {
        return new  Theatre(
                request.getName(),
                request.getAddress(),
                request.getCity(),
                request.getDescription(),
                request.getCapacity(),
                request.getStageWidthMm(),
                request.getStageDepthMm()
        );
    }

    public TheatreResponse toResponse(Theatre theatre) {
        TheatreResponse response = new TheatreResponse(
                theatre.getId(),
                theatre.getName(),
                theatre.getAddress(),
                theatre.getCity(),
                theatre.getDescription(),
                theatre.getCreatedAt(),
                theatre.getUpdatedAt(),
                theatre.getCapacity(),
                theatre.getStageWidthMm(),
                theatre.getStageDepthMm()
        );
        response.setVenueType(VenueType.THEATRE);
        return response;
    }
}
