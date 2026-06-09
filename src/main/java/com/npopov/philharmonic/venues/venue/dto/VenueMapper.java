package com.npopov.philharmonic.venues.venue.dto;

import com.npopov.philharmonic.venues.venue.domain.Venue;
import org.springframework.stereotype.Component;

@Component
public class VenueMapper {
    private VenueMapper() {}

    public Venue toVenueFromCreate(VenueCreateRequest request) {
        if (request == null) return new Venue();
        return new Venue(
                request.getName(),
                request.getAddress(),
                request.getCity(),
                request.getDescription()
        );
    }

    public Venue toVenueFromUpdate(VenueUpdateRequest request) {
        if (request == null) return new Venue();
        return new Venue(
                request.getName(),
                request.getAddress(),
                request.getCity(),
                request.getDescription()
        );
    }

    public VenueResponse toResponse(Venue venue) {
        if (venue == null) return null;
        return new VenueResponse(
                venue.getId(),
                venue.getName(),
                venue.getAddress(),
                venue.getCity(),
                venue.getDescription(),
                venue.getCreatedAt(),
                venue.getUpdatedAt()
        );
    }
}
