package com.npopov.philharmonic.event.dto;

import com.npopov.philharmonic.event.domain.Competition;
import com.npopov.philharmonic.genre.domain.Genre;
import com.npopov.philharmonic.organizer.domain.Organizer;
import com.npopov.philharmonic.organizer.repository.OrganizerRepository;
import com.npopov.philharmonic.venue.domain.Venue;
import com.npopov.philharmonic.venue.repository.VenueRepository;
import jakarta.persistence.EntityManager;
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
        return new CompetitionResponse(
                competition.getId(),
                competition.getTitle(),
                competition.getVenue().getId(),
                competition.getOrganizer().getId(),
                competition.getStartDatetime(),
                competition.getEndDatetime(),
                competition.getDescription(),
                competition.getCreatedAt(),
                competition.getUpdatedAt(),
                competition.getCompetitionType(),
                competition.getRules(),
                competition.getJuryInfo()
        );
    }
}