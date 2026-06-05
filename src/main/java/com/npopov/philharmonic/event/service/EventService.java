package com.npopov.philharmonic.event.service;

import com.npopov.philharmonic.event.domain.Event;
import com.npopov.philharmonic.organizer.domain.Organizer;
import com.npopov.philharmonic.shared.exception.ResourceNotFoundException;
import com.npopov.philharmonic.venue.domain.Venue;
import com.npopov.philharmonic.event.dto.EventCreateRequest;
import com.npopov.philharmonic.event.dto.EventResponse;
import com.npopov.philharmonic.event.repository.EventRepository;
import com.npopov.philharmonic.organizer.service.OrganizerService;
import com.npopov.philharmonic.venue.service.VenueService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final VenueService venueService;
    private final OrganizerService organizerService;

    public EventService(EventRepository eventRepository, VenueService venueService, OrganizerService organizerService) {
        this.eventRepository = eventRepository;
        this.venueService = venueService;
        this.organizerService = organizerService;
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public List<Event> findByPeriod(LocalDateTime start, LocalDateTime end) {
        return eventRepository.findByStartDatetimeBetween(start, end);
    }

    public List<Event> findByOrganizer(Long organizerId) {
        return eventRepository.findByOrganizer_Id(organizerId);
    }

    public List<Event> findByVenue(Long venueId) {
        return eventRepository.findByVenue_Id(venueId);
    }

    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }

//    public Event createFromRequest(EventCreateRequest request) {
//        Venue venue = venueService.findById(request.venueId())
//                .orElseThrow(() -> new ResourceNotFoundException("Venue not found"));
//        Organizer organizer = request.organizerId() != null
//                ? organizerService.findById(request.organizerId()).orElse(null) : null;
//        Event event = new Event(
//                request.title(),
//                request.eventType(),
//                venue,
//                organizer,
//                request.startDatetime(),
//                request.endDatetime(),
//                request.description());
//        return save(event);
//    }

    public EventResponse toResponse(Event event) {
        return new EventResponse(
                event.getId(),
                event.getTitle(),
                event.getEventType(),
                event.getVenue() != null ? event.getVenue().getId() : null,
                event.getVenue() != null ? event.getOrganizer().getId(): null,
                event.getStartDatetime(),
                event.getEndDatetime(),
                event.getDescription(),
                event.getCreatedAt(),
                event.getUpdatedAt()
        );
    }

    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }
}