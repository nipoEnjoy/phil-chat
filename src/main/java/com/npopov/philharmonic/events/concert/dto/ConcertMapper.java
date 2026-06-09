package com.npopov.philharmonic.events.concert.dto;

import com.npopov.philharmonic.events.concert.domain.Concert;
import com.npopov.philharmonic.events.event.domain.EventType;
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

    public Concert toConcertFromCreate(ConcertCreateRequest req) {
        Venue venue = venueRepository.getReferenceById(req.getVenueId());
        Organizer organizer = req.getOrganizerId() != null
                ? organizerRepository.getReferenceById(req.getOrganizerId())
                : null;

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

    public Concert toConcertFromUpdate(ConcertUpdateRequest req) {
        Venue venue = venueRepository.getReferenceById(req.getVenueId());
        Organizer organizer = req.getOrganizerId() != null
                ? organizerRepository.getReferenceById(req.getOrganizerId())
                : null;

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
        ConcertResponse response = new ConcertResponse(
                concert.getId(),
                concert.getTitle(),
                concert.getVenue().getId(),
                concert.getVenue().getName(),
                concert.getOrganizer().getId(),
                concert.getOrganizer().getName(),
                concert.getStartDatetime(),
                concert.getEndDatetime(),
                concert.getDescription(),
                concert.getCreatedAt(),
                concert.getUpdatedAt(),
                concert.getProgram()
        );
        response.setEventType(EventType.CONCERT);
        return response;
    }
}