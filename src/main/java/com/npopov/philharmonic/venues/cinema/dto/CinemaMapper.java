package com.npopov.philharmonic.venues.cinema.dto;

import com.npopov.philharmonic.venues.cinema.domain.Cinema;
import com.npopov.philharmonic.venues.venue.domain.VenueType;
import org.springframework.stereotype.Component;

@Component
public class CinemaMapper {

    public Cinema toCinemaFromCreate(CinemaCreateRequest request) {
        return new Cinema(
                request.getName(),
                request.getAddress(),
                request.getCity(),
                request.getDescription(),
                request.getScreenWidthMm(),
                request.getScreenHeightMm(),
                request.getScreenDiagonalMm(),
                request.getScreenAspectRatio()
        );
    }

    public Cinema toCinemaFromUpdate(CinemaUpdateRequest request) {
        return new Cinema(
                request.getName(),
                request.getAddress(),
                request.getCity(),
                request.getDescription(),
                request.getScreenWidthMm(),
                request.getScreenHeightMm(),
                request.getScreenDiagonalMm(),
                request.getScreenAspectRatio()
        );
    }

    public CinemaResponse toResponse(Cinema cinema) {
        CinemaResponse response = new CinemaResponse(
                cinema.getId(),
                cinema.getName(),
                cinema.getAddress(),
                cinema.getCity(),
                cinema.getDescription(),
                cinema.getCreatedAt(),
                cinema.getUpdatedAt(),
                cinema.getScreenWidthMm(),
                cinema.getScreenHeightMm(),
                cinema.getScreenDiagonalMm(),
                cinema.getScreenAspectRatio()
        );
        response.setVenueType(VenueType.CINEMA);
        return response;
    }
}
