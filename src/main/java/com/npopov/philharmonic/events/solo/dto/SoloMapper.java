package com.npopov.philharmonic.events.solo.dto;

import com.npopov.philharmonic.events.event.domain.EventType;
import com.npopov.philharmonic.events.solo.domain.Solo;
import com.npopov.philharmonic.organizer.domain.Organizer;
import com.npopov.philharmonic.organizer.repository.OrganizerRepository;
import com.npopov.philharmonic.venues.venue.domain.Venue;
import com.npopov.philharmonic.venues.venue.repository.VenueRepository;
import org.springframework.stereotype.Component;

@Component
public class SoloMapper {

    private final VenueRepository venueRepository;
    private final OrganizerRepository organizerRepository;

    public SoloMapper(VenueRepository venueRepository, OrganizerRepository organizerRepository) {
        this.venueRepository = venueRepository;
        this.organizerRepository = organizerRepository;
    }

    public Solo toSoloFromCreate(SoloCreateRequest request) {
        Venue venue = venueRepository.getReferenceById(request.getVenueId());
        Organizer organizer = request.getOrganizerId() != null
                ? organizerRepository.getReferenceById(request.getOrganizerId())
                : null;

        return new Solo(
                request.getTitle(),
                venue,
                organizer,
                request.getStartDatetime(),
                request.getEndDatetime(),
                request.getDescription()
        );
    }

    public Solo toSoloFromUpdate(SoloUpdateRequest request) {
        Venue venue = venueRepository.getReferenceById(request.getVenueId());
        Organizer organizer = request.getOrganizerId() != null
                ? organizerRepository.getReferenceById(request.getOrganizerId())
                : null;

        return new Solo(
                request.getTitle(),
                venue,
                organizer,
                request.getStartDatetime(),
                request.getEndDatetime(),
                request.getDescription()
        );
    }

    public SoloResponse toResponse(Solo solo) {
        SoloResponse response =  new SoloResponse(
                solo.getId(),
                solo.getTitle(),
                solo.getVenue().getId(),
                solo.getVenue().getName(),
                solo.getOrganizer().getId(),
                solo.getOrganizer().getName(),
                solo.getStartDatetime(),
                solo.getEndDatetime(),
                solo.getDescription(),
                solo.getCreatedAt(),
                solo.getUpdatedAt()
        );
        response.setEventType(EventType.SOLO);
        return response;
    }
}