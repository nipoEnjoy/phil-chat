package com.npopov.philharmonic.venues.concert.dto;

import com.npopov.philharmonic.venues.concert.domain.ConcertVenue;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ConcertVenueMapper {

    public ConcertVenueMapper() {
    }

    public ConcertVenue toConcertVenueFromCreate(ConcertVenueCreateRequest request) {
        return new ConcertVenue(
                request.getName(),
                request.getAddress(),
                request.getCity(),
                request.getDescription(),
                request.getStageType(),
                request.getHasSoundSystem()
        );
    }

    public ConcertVenue toConcertVenueFromUpdate(ConcertVenueUpdateRequest request) {
        return new ConcertVenue(
                request.getName(),
                request.getAddress(),
                request.getCity(),
                request.getDescription(),
                request.getStageType(),
                request.getHasSoundSystem()
        );
    }

    public ConcertVenueResponse toResponse(ConcertVenue concertVenue) {
        return new ConcertVenueResponse(
                concertVenue.getId(),
                concertVenue.getName(),
                concertVenue.getAddress(),
                concertVenue.getCity(),
                concertVenue.getDescription(),
                concertVenue.getCreatedAt(),
                concertVenue.getUpdatedAt(),
                concertVenue.getStageType(),
                concertVenue.getHasSoundSystem()
        );
    }
}