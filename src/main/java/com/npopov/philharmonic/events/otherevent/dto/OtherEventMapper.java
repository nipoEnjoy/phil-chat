package com.npopov.philharmonic.events.otherevent.dto;

import com.npopov.philharmonic.events.event.domain.EventType;
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

    public OtherEvent toOtherEventFromCreate(OtherEventCreateRequest req) {
        Venue venue = venueRepository.getReferenceById(req.getVenueId());
        Organizer organizer = req.getOrganizerId() != null
                ? organizerRepository.getReferenceById(req.getOrganizerId())
                : null;

        return new OtherEvent(
                req.getTitle(),
                venue,
                organizer,
                req.getStartDatetime(),
                req.getEndDatetime(),
                req.getDescription()
        );
    }

    public OtherEvent toOtherEventFromUpdate(OtherEventUpdateRequest req) {
        Venue venue = venueRepository.getReferenceById(req.getVenueId());
        Organizer organizer = req.getOrganizerId() != null
                ? organizerRepository.getReferenceById(req.getOrganizerId())
                : null;

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
        OtherEventResponse response = new OtherEventResponse(
                otherEvent.getId(),
                otherEvent.getTitle(),
                otherEvent.getVenue().getId(),
                otherEvent.getVenue().getName(),
                otherEvent.getOrganizer().getId(),
                otherEvent.getOrganizer().getName(),
                otherEvent.getStartDatetime(),
                otherEvent.getEndDatetime(),
                otherEvent.getDescription(),
                otherEvent.getCreatedAt(),
                otherEvent.getUpdatedAt()
        );
        response.setEventType(EventType.OTHER);
        return response;
    }
}