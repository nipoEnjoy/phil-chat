package com.npopov.philharmonic.venue.service;
import com.npopov.philharmonic.venue.domain.Venue;
import com.npopov.philharmonic.venue.domain.VenueType;
import com.npopov.philharmonic.shared.service.JpaCrudService;
import com.npopov.philharmonic.venue.repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService extends JpaCrudService<Venue, Long> {

    private final VenueRepository repository;

    public VenueService(VenueRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<Venue> findByVenueType(VenueType type) {
        return repository.findByVenueType(type);
    }
}