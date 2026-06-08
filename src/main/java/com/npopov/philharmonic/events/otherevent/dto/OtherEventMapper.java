package com.npopov.philharmonic.events.otherevent.dto;

import com.npopov.philharmonic.events.otherevent.domain.OtherEvent;
import com.npopov.philharmonic.organizer.domain.Organizer;
import com.npopov.philharmonic.organizer.repository.OrganizerRepository;
import com.npopov.philharmonic.venues.venue.domain.Venue;
import com.npopov.philharmonic.venues.venue.repository.VenueRepository;
import org.springframework.stereotype.Component;

@Component
public class OtherEventMapper {

    private final VenueRepository venueRepository;
    private final OrganizerRepository organizerRepository;

    public OtherEventMapper(VenueRepository venueRepository,
                            OrganizerRepository organizerRepository) {
        this.venueRepository = venueRepository;
        this.organizerRepository = organizerRepository;
    }

    public OtherEvent createFromRequest(OtherEventCreateRequest req) {
        Venue venue = venueRepository.getReferenceById(req.getVenueId());
        Organizer organizer = organizerRepository.getReferenceById(req.getOrganizerId());

        return new OtherEvent(
                req.getTitle(),
                venue,
                organizer,
                req.getStartDatetime(),
                req.getEndDatetime(),
                req.getDescription()
        );
    }

    public OtherEvent updateFromRequest(OtherEventUpdateRequest req) {
        Venue venue = venueRepository.getReferenceById(req.getVenueId());
        Organizer organizer = organizerRepository.getReferenceById(req.getOrganizerId());

        return new OtherEvent(
                req.getTitle(),
                venue,
                organizer,
                req.getStartDatetime(),
                req.getEndDatetime(),
                req.getDescription()
        );
    }

    public OtherEventResponse toResponse(OtherEvent otherEvent) {
        return new OtherEventResponse(
                otherEvent.getId(),
                otherEvent.getTitle(),
                otherEvent.getVenue().getId(),
                otherEvent.getOrganizer().getId(),
                otherEvent.getStartDatetime(),
                otherEvent.getEndDatetime(),
                otherEvent.getDescription(),
                otherEvent.getCreatedAt(),
                otherEvent.getUpdatedAt()
        );
    }
}