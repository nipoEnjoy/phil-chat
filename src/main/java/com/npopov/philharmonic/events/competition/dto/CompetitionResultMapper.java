package com.npopov.philharmonic.events.competition.dto;

import com.npopov.philharmonic.artist.repository.ArtistRepository;
import com.npopov.philharmonic.events.competition.domain.CompetitionResult;
import com.npopov.philharmonic.events.competition.repository.CompetitionRepository;
import org.springframework.stereotype.Component;

@Component
public class CompetitionResultMapper {

    private final CompetitionRepository competitionRepository;
    private final ArtistRepository artistRepository;

    public CompetitionResultMapper(CompetitionRepository competitionRepository, ArtistRepository artistRepository) {
        this.competitionRepository = competitionRepository;
        this.artistRepository = artistRepository;
    }

    public CompetitionResult toCompetitionResultFromCreate(CompetitionResultCreateRequest request) {
        return new CompetitionResult(
                competitionRepository.getReferenceById(request.getCompetitionId()),
                artistRepository.getReferenceById(request.getArtistId()),
                request.getPlace(),
                request.getAward()
        );
    }

    public CompetitionResult toCompetitionResultFromUpdate(CompetitionResultUpdateRequest request) {
        return new CompetitionResult(
                competitionRepository.getReferenceById(request.getCompetitionId()),
                artistRepository.getReferenceById(request.getArtistId()),
                request.getPlace(),
                request.getAward()
        );
    }

    public CompetitionResultResponse toResponse(CompetitionResult competitionResult) {
        return new CompetitionResultResponse(
                competitionResult.getId(),
                competitionResult.getCompetition().getId(),
                competitionResult.getArtist().getId(),
                competitionResult.getPlace(),
                competitionResult.getAward(),
                competitionResult.getCreatedAt(),
                competitionResult.getUpdatedAt()
        );
    }
}
