package com.npopov.philharmonic.events.event.service;

import com.npopov.philharmonic.events.competition.domain.Competition;
import com.npopov.philharmonic.events.competition.dto.CompetitionCreateRequest;
import com.npopov.philharmonic.events.competition.dto.CompetitionMapper;
import com.npopov.philharmonic.events.competition.dto.CompetitionUpdateRequest;
import com.npopov.philharmonic.events.concert.domain.Concert;
import com.npopov.philharmonic.events.concert.dto.ConcertCreateRequest;
import com.npopov.philharmonic.events.concert.dto.ConcertMapper;
import com.npopov.philharmonic.events.concert.dto.ConcertUpdateRequest;
import com.npopov.philharmonic.events.event.domain.Event;
import com.npopov.philharmonic.events.event.dto.EventCreateRequest;
import com.npopov.philharmonic.events.event.dto.EventResponse;
import com.npopov.philharmonic.events.event.dto.EventUpdateRequest;
import com.npopov.philharmonic.events.event.repository.EventRepository;
import com.npopov.philharmonic.events.festival.domain.Festival;
import com.npopov.philharmonic.events.festival.dto.FestivalCreateRequest;
import com.npopov.philharmonic.events.festival.dto.FestivalMapper;
import com.npopov.philharmonic.events.festival.dto.FestivalUpdateRequest;
import com.npopov.philharmonic.events.otherevent.domain.OtherEvent;
import com.npopov.philharmonic.events.otherevent.dto.OtherEventCreateRequest;
import com.npopov.philharmonic.events.otherevent.dto.OtherEventMapper;
import com.npopov.philharmonic.events.otherevent.dto.OtherEventUpdateRequest;
import com.npopov.philharmonic.events.solo.domain.Solo;
import com.npopov.philharmonic.events.solo.dto.SoloCreateRequest;
import com.npopov.philharmonic.events.solo.dto.SoloMapper;
import com.npopov.philharmonic.events.solo.dto.SoloUpdateRequest;
import com.npopov.philharmonic.organizer.service.OrganizerService;
import com.npopov.philharmonic.shared.service.JpaCrudService;
import com.npopov.philharmonic.venues.venue.service.VenueService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService extends JpaCrudService<Event, Long> {

    private final EventRepository eventRepository;
    private final VenueService venueService;
    private final OrganizerService organizerService;

    private final ConcertMapper concertMapper;
    private final CompetitionMapper competitionMapper;
    private final SoloMapper soloMapper;
    private final FestivalMapper festivalMapper;
    private final OtherEventMapper otherEventMapper;

    public EventService(EventRepository eventRepository, VenueService venueService, OrganizerService organizerService, ConcertMapper concertMapper, CompetitionMapper competitionMapper, SoloMapper soloMapper, FestivalMapper festivalMapper, OtherEventMapper otherEventMapper) {
        super(eventRepository);
        this.eventRepository = eventRepository;
        this.venueService = venueService;
        this.organizerService = organizerService;
        this.concertMapper = concertMapper;
        this.competitionMapper = competitionMapper;
        this.soloMapper = soloMapper;
        this.festivalMapper = festivalMapper;
        this.otherEventMapper = otherEventMapper;
    }

//    public List<Event> getAll() {
//        return eventRepository.findAll();
//    }

    public List<Event> findByPeriod(LocalDateTime start, LocalDateTime end) {
        return eventRepository.findByStartDatetimeBetween(start, end);
    }

    public List<Event> findByOrganizer(Long organizerId) {
        return eventRepository.findByOrganizer_Id(organizerId);
    }

    public List<Event> findByVenue(Long venueId) {
        return eventRepository.findByVenue_Id(venueId);
    }

    @Transactional
    public Event createFromRequest(EventCreateRequest request) {
        Event event = switch (request) {
            case ConcertCreateRequest concertCreateRequest ->
                    concertMapper.toConcertFromCreate(concertCreateRequest);
            case CompetitionCreateRequest competitionCreateRequest ->
                    competitionMapper.toCompetitionFromCreate(competitionCreateRequest);
            case SoloCreateRequest soloCreateRequest ->
                    soloMapper.toSoloFromCreate(soloCreateRequest);
            case FestivalCreateRequest festivalCreateRequest ->
                    festivalMapper.toFestivalFromCreate(festivalCreateRequest);
            case OtherEventCreateRequest otherEventCreateRequest ->
                    otherEventMapper.toOtherEventFromCreate(otherEventCreateRequest);
            default ->
                    throw new IllegalArgumentException("Unknown event type: " + request.getClass());
        };
        return eventRepository.save(event);
    }

    @Transactional
    public Event updateFromRequest(EventUpdateRequest request) {
        Event event = switch (request) {
            case ConcertUpdateRequest concertUpdateRequest ->
                    concertMapper.toConcertFromUpdate(concertUpdateRequest);
            case CompetitionUpdateRequest competitionUpdateRequest ->
                    competitionMapper.toCompetitionFromUpdate(competitionUpdateRequest);
            case SoloUpdateRequest soloUpdateRequest ->
                    soloMapper.toSoloFromUpdate(soloUpdateRequest);
            case FestivalUpdateRequest festivalUpdateRequest ->
                    festivalMapper.toFestivalFromUpdate(festivalUpdateRequest);
            case OtherEventUpdateRequest otherEventUpdateRequest ->
                    otherEventMapper.toOtherEventFromUpdate(otherEventUpdateRequest);
            default ->
                    throw new IllegalArgumentException("Unknown event type: " + request.getClass());
        };
        return eventRepository.save(event);
    }

    public EventResponse toResponse(Event event) {
        return switch (event) {
            case Concert concert -> concertMapper.toResponse(concert);
            case Competition competition -> competitionMapper.toResponse(competition);
            case Solo solo-> soloMapper.toResponse(solo);
            case Festival festival -> festivalMapper.toResponse(festival);
            case OtherEvent otherEvent -> otherEventMapper.toResponse(otherEvent);
            default -> throw new IllegalArgumentException("Unknown event type: " + event.getClass());
        };
    }

    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }
}