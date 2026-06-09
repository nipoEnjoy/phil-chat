package com.npopov.philharmonic.organizer.service;

import com.npopov.philharmonic.organizer.domain.Organizer;
import com.npopov.philharmonic.organizer.repository.OrganizerRepository;
import com.npopov.philharmonic.shared.service.JpaCrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizerService extends JpaCrudService<Organizer, Long> {

    private final OrganizerRepository organizerRepository;

    public OrganizerService(OrganizerRepository organizerRepository) {
        super(organizerRepository);
        this.organizerRepository = organizerRepository;
    }
}