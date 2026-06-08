package com.npopov.philharmonic.venues.concert.service;

import com.npopov.philharmonic.shared.service.JpaCrudService;
import com.npopov.philharmonic.venues.concert.domain.ConcertVenue;
import com.npopov.philharmonic.venues.concert.repository.ConcertVenueRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ConcertVenueService extends JpaCrudService<ConcertVenue, Long> {

    private final ConcertVenueRepository concertVenueRepository;

    public ConcertVenueService(JpaRepository<ConcertVenue, Long> repository, ConcertVenueRepository concertVenueRepository) {
        super(repository);
        this.concertVenueRepository = concertVenueRepository;
    }
}
