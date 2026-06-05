package com.npopov.philharmonic.event.controller;

import com.npopov.philharmonic.event.dto.EventCreateRequest;
import com.npopov.philharmonic.event.dto.EventResponse;
import com.npopov.philharmonic.event.domain.Event;
import com.npopov.philharmonic.event.service.EventService;
import com.npopov.philharmonic.shared.controller.GenericRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/events")
public class EventController {

//    private final GenericRestController<Event, Long, EventResponse, EventCreateRequest> eventRestController;


    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<EventResponse> getAllEvents(@RequestParam(required = false) LocalDateTime start, @RequestParam(required = false) LocalDateTime end,
                                            @RequestParam(required = false) Long organizerId, @RequestParam(required = false) Long venueId) {
        List<Event> events;
        if (start != null && end != null) {
            events = eventService.findByPeriod(start, end);
        } else if (organizerId != null) {
            events = eventService.findByOrganizer(organizerId);
        } else if (venueId != null) {
            events = eventService.findByVenue(venueId);
        } else {
            events = eventService.findAll();
        }
        return events.stream().map(eventService::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponse> getEventById(@PathVariable Long id) {
        return eventService.findById(id)
                .map(event -> ResponseEntity.ok(eventService.toResponse(event)))
                .orElse(ResponseEntity.notFound().build());
    }

//    @PostMapping
//    public EventResponse createEvent(@RequestBody EventCreateRequest request) {
//        Event event = eventService.createFromRequest(request);
//        return eventService.toResponse(event);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        if (!eventService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        event.setId(id);
        return ResponseEntity.ok(eventService.save(event));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        if (!eventService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        eventService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}