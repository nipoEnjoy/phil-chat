package com.npopov.philharmonic.venue.dto;

import com.npopov.philharmonic.venue.domain.Venue;

public class VenueMapper {
    private VenueMapper() {}

//    public static Venue toVenue(VenueCreateRequest request) {
//        if (request == null) return new Venue();
//        return new Venue(
//                request.name(),
//                request.venueType(),
//                request.address(),
//                request.city(),
//                request.description()
//        );
//    }
//
//    public static Venue toVenue(VenueUpdateRequest request) {
//        if (request == null) return new Venue();
//        return new Venue(
//                request.name(),
//                request.venueType(),
//                request.address(),
//                request.city(),
//                request.description()
//        );
//    }

    public static VenueResponse toResponse(Venue venue) {
        if (venue == null) return null;
        return new VenueResponse(
                venue.getId(),
                venue.getName(),
                venue.getVenueType(),
                venue.getAddress(),
                venue.getCity(),
                venue.getDescription(),
                venue.getCreatedAt(),
                venue.getUpdatedAt()
        );
    }
}
