package com.npopov.philharmonic.organizer.service;

import com.npopov.philharmonic.organizer.domain.Organizer;
import com.npopov.philharmonic.organizer.repository.OrganizerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizerService {

    private final OrganizerRepository organizerRepository;

    public OrganizerService(OrganizerRepository organizerRepository) {
        this.organizerRepository = organizerRepository;
    }

    public List<Organizer> findAll() {
        return organizerRepository.findAll();
    }

    public Optional<Organizer> findById(Long id) {
        return organizerRepository.findById(id);
    }

    public Organizer save(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public void deleteById(Long id) {
        organizerRepository.deleteById(id);
    }
}