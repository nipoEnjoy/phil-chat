package com.npopov.philharmonic.event.dto;

import com.npopov.philharmonic.event.domain.Competition;
import com.npopov.philharmonic.genre.domain.Genre;

public class CompetitionMapper {
    private CompetitionMapper() {}

    public static Competition toCompetition(CompetitionCreateRequest request) {
        return new Competition(
                request.eventId()
        );
    }
}
