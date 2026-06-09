package com.npopov.philharmonic.events.competition.dto;

import com.npopov.philharmonic.events.competition.domain.Competition;
import com.npopov.philharmonic.events.event.domain.EventType;
import com.npopov.philharmonic.organizer.repository.OrganizerRepository;
import com.npopov.philharmonic.venues.venue.repository.VenueRepository;
import org.springframework.stereotype.Component;

@Component
public class CompetitionMapper {

    private final VenueRepository venueRepository;
    private final OrganizerRepository organizerRepository;

    public CompetitionMapper(VenueRepository venueRepository, OrganizerRepository organizerRepository) {
        this.venueRepository = venueRepository;
        this.organizerRepository = organizerRepository;
    }

    public Competition toCompetitionFromCreate(CompetitionCreateRequest request) {
        return new Competition(
                request.getTitle(),
                venueRepository.getReferenceById(request.getVenueId()),
                organizerRepository.getReferenceById(request.getOrganizerId()),
                request.getStartDatetime(),
                request.getEndDatetime(),
                request.getDescription(),
                request.getCompetitionType(),
                request.getRules(),
                request.getJuryInfo()
        );
    }

    public Competition toCompetitionFromUpdate(CompetitionUpdateRequest request) {
        return new Competition(
                request.getTitle(),
                venueRepository.getReferenceById(request.getVenueId()),
                organizerRepository.getReferenceById(request.getOrganizerId()),
                request.getStartDatetime(),
                request.getEndDatetime(),
                request.getDescription(),
                request.getCompetitionType(),
                request.getRules(),
                request.getJuryInfo()
        );
    }

    public CompetitionResponse toResponse(Competition competition) {
        CompetitionResponse response = new CompetitionResponse(
                competition.getId(),
                competition.getTitle(),
                competition.getVenue().getId(),
                competition.getVenue().getName(),
                competition.getOrganizer().getId(),
                competition.getOrganizer().getName(),
                competition.getStartDatetime(),
                competition.getEndDatetime(),
                competition.getDescription(),
                competition.getCreatedAt(),
                competition.getUpdatedAt(),
                competition.getCompetitionType(),
                competition.getRules(),
                competition.getJuryInfo()
        );
        response.setEventType(EventType.COMPETITION);
        return response;
    }
}