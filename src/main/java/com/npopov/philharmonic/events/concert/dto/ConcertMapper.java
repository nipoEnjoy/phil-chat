package com.npopov.philharmonic.events.concert.dto;

import com.npopov.philharmonic.events.concert.domain.Concert;
import com.npopov.philharmonic.organizer.domain.Organizer;
import com.npopov.philharmonic.organizer.repository.OrganizerRepository;
import com.npopov.philharmonic.venues.venue.domain.Venue;
import com.npopov.philharmonic.venues.venue.repository.VenueRepository;
import org.springframework.stereotype.Component;

@Component
public class ConcertMapper {

    private final VenueRepository venueRepository;
    private final OrganizerRepository organizerRepository;

    public ConcertMapper(VenueRepository venueRepository,
                            OrganizerRepository organizerRepository) {
        this.venueRepository = venueRepository;
        this.organizerRepository = organizerRepository;
    }

    public Concert concertFromCreate(ConcertCreateRequest req) {
        Venue venue = venueRepository.getReferenceById(req.getVenueId());
        Organizer organizer = organizerRepository.getReferenceById(req.getOrganizerId());

        return new Concert(
                req.getTitle(),
                venue,
                organizer,
                req.getStartDatetime(),
                req.getEndDatetime(),
                req.getDescription(),
                req.getProgram()
        );
    }

    public Concert concertFromUpdate(ConcertUpdateRequest req) {
        Venue venue = venueRepository.getReferenceById(req.getVenueId());
        Organizer organizer = organizerRepository.getReferenceById(req.getOrganizerId());

        return new Concert(
                req.getTitle(),
                venue,
                organizer,
                req.getStartDatetime(),
                req.getEndDatetime(),
                req.getDescription(),
                req.getProgram()
        );
    }

    public ConcertResponse toResponse(Concert concert) {
        return new ConcertResponse(
                concert.getId(),
                concert.getTitle(),
                concert.getVenue().getId(),
                concert.getOrganizer().getId(),
                concert.getStartDatetime(),
                concert.getEndDatetime(),
                concert.getDescription(),
                concert.getCreatedAt(),
                concert.getUpdatedAt(),
                concert.getProgram()
        );
    }
}