package com.npopov.philharmonic.reports.service;

import com.npopov.philharmonic.artist.repository.ArtistRepository;
import com.npopov.philharmonic.events.event.repository.EventRepository;
import com.npopov.philharmonic.reports.dto.ArtistNoCompetition;
import com.npopov.philharmonic.reports.dto.OrganizerStat;
import com.npopov.philharmonic.reports.dto.VenueWithEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ReportService {

    private final ArtistRepository artistRepository;
    private final EventRepository eventRepository;

    public ReportService(ArtistRepository artistRepository, EventRepository eventRepository) {
        this.artistRepository = artistRepository;
        this.eventRepository = eventRepository;
    }

    public List<ArtistNoCompetition> getArtistsWithoutCompetitions(LocalDateTime start, LocalDateTime end) {
        return artistRepository.findArtistsWithoutCompetitionsInPeriod(start, end).stream()
                .map(a -> new ArtistNoCompetition(a.getId(), a.getFirstName(), a.getLastName(), a.getStageName()))
                .collect(Collectors.toList());
    }

    public List<OrganizerStat> getOrganizerConcertStats(LocalDateTime start, LocalDateTime end) {
        return eventRepository.countConcertsByOrganizerInPeriod(start, end).stream()
                .map(row -> new OrganizerStat((Long) row[0], (String) row[1], (Long) row[2]))
                .collect(Collectors.toList());
    }

    public List<VenueWithEvent> getVenuesWithEvents(LocalDateTime start, LocalDateTime end) {
        return eventRepository.findVenuesWithEventsInPeriod(start, end).stream()
                .map(row -> new VenueWithEvent((Long) row[0], (String) row[1], (Long) row[2], (String) row[3], (LocalDateTime) row[4]))
                .collect(Collectors.toList());
    }
}