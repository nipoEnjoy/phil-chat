package com.npopov.philharmonic.events.festival.dto;

import com.npopov.philharmonic.events.event.domain.EventType;
import com.npopov.philharmonic.events.festival.domain.Festival;
import com.npopov.philharmonic.organizer.domain.Organizer;
import com.npopov.philharmonic.organizer.repository.OrganizerRepository;
import com.npopov.philharmonic.venues.venue.domain.Venue;
import com.npopov.philharmonic.venues.venue.repository.VenueRepository;
import org.springframework.stereotype.Component;

@Component
public class FestivalMapper {

    private final VenueRepository venueRepository;
    private final OrganizerRepository organizerRepository;

    public FestivalMapper(VenueRepository venueRepository, OrganizerRepository organizerRepository) {
        this.venueRepository = venueRepository;
        this.organizerRepository = organizerRepository;
    }

    public Festival toFestivalFromCreate(FestivalCreateRequest request) {
        Venue venue = venueRepository.getReferenceById(request.getVenueId());
        Organizer organizer = request.getOrganizerId() != null
                ? organizerRepository.getReferenceById(request.getOrganizerId())
                : null;

        return new Festival(
                request.getTitle(),
                venue,
                organizer,
                request.getStartDatetime(),
                request.getEndDatetime(),
                request.getDescription()
        );
    }

    public Festival toFestivalFromUpdate(FestivalUpdateRequest request) {
        Venue venue = venueRepository.getReferenceById(request.getVenueId());
        Organizer organizer = request.getOrganizerId() != null
                ? organizerRepository.getReferenceById(request.getOrganizerId())
                : null;

        return new Festival(
                request.getTitle(),
                venue,
                organizer,
                request.getStartDatetime(),
                request.getEndDatetime(),
                request.getDescription()
        );
    }

    public FestivalResponse toResponse(Festival festival) {
        FestivalResponse response = new FestivalResponse(
                festival.getId(),
                festival.getTitle(),
                festival.getVenue().getId(),
                festival.getVenue().getName(),
                festival.getOrganizer().getId(),
                festival.getOrganizer().getName(),
                festival.getStartDatetime(),
                festival.getEndDatetime(),
                festival.getDescription(),
                festival.getCreatedAt(),
                festival.getUpdatedAt()
        );
        response.setEventType(EventType.FESTIVAL);
        return response;
    }
}