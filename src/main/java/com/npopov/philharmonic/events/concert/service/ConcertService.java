package com.npopov.philharmonic.events.concert.service;

import com.npopov.philharmonic.events.concert.domain.Concert;
import com.npopov.philharmonic.events.concert.repository.ConcertRepository;
import com.npopov.philharmonic.shared.service.JpaCrudService;
import org.springframework.stereotype.Service;

@Service
public class ConcertService extends JpaCrudService<Concert, Long> {

    private final ConcertRepository concertRepository;

    public ConcertService(ConcertRepository concertRepository) {
        super(concertRepository);
        this.concertRepository = concertRepository;
    }
}
