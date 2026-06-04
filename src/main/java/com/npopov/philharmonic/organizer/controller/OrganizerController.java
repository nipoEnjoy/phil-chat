package com.npopov.philharmonic.organizer.controller;

import com.npopov.philharmonic.organizer.domain.Organizer;
import com.npopov.philharmonic.organizer.service.OrganizerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizers")
public class OrganizerController {

    private final OrganizerService organizerService;

    public OrganizerController(OrganizerService organizerService) {
        this.organizerService = organizerService;
    }

    @GetMapping
    public List<Organizer> getAllOrganizers() {
        return organizerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organizer> getOrganizerById(@PathVariable Long id) {
        return organizerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Organizer createOrganizer(@RequestBody Organizer organizer) {
        return organizerService.save(organizer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Organizer> updateOrganizer(@PathVariable Long id, @RequestBody Organizer organizer) {
        if (!organizerService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        organizer.setId(id);
        return ResponseEntity.ok(organizerService.save(organizer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable Long id) {
        if (!organizerService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        organizerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}