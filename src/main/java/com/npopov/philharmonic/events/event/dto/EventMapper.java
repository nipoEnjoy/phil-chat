package com.npopov.philharmonic.events.event.dto;

import com.npopov.philharmonic.events.event.domain.Event;
import com.npopov.philharmonic.organizer.domain.Organizer;
import com.npopov.philharmonic.organizer.repository.OrganizerRepository;
import com.npopov.philharmonic.venues.venue.domain.Venue;
import com.npopov.philharmonic.venues.venue.repository.VenueRepository;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    private final VenueRepository venueRepository;
    private final OrganizerRepository organizerRepository;

    public EventMapper(VenueRepository venueRepository, OrganizerRepository organizerRepository) {
        this.venueRepository = venueRepository;
        this.organizerRepository = organizerRepository;
    }

    public Event toEventFromCreate(EventCreateRequest request) {
        Venue venue = venueRepository.getReferenceById(request.getVenueId());
        Organizer organizer = request.getOrganizerId() != null
                ? organizerRepository.getReferenceById(request.getOrganizerId())
                : null;

        return new Event(
                request.getTitle(),
                venue,
                organizer,
                request.getStartDatetime(),
                request.getEndDatetime(),
                request.getDescription()
        );
    }

    public Event toEventFromUpdate(EventUpdateRequest request) {
        Venue venue = venueRepository.getReferenceById(request.getVenueId());
        Organizer organizer = request.getOrganizerId() != null
                ? organizerRepository.getReferenceById(request.getOrganizerId())
                : null;

        return new Event(
                request.getTitle(),
                venue,
                organizer,
                request.getStartDatetime(),
                request.getEndDatetime(),
                request.getDescription()
        );
    }

    public EventResponse toResponse(Event event) {
        return new EventResponse(
                event.getId(),
                event.getTitle(),
                event.getVenue().getId(),
                event.getVenue().getName(),
                event.getOrganizer().getId(),
                event.getOrganizer().getName(),
                event.getStartDatetime(),
                event.getEndDatetime(),
                event.getDescription(),
                event.getCreatedAt(),
                event.getUpdatedAt()
        );
    }
}