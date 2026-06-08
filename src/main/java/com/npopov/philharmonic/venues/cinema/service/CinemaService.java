package com.npopov.philharmonic.venues.cinema.service;

import com.npopov.philharmonic.shared.service.JpaCrudService;
import com.npopov.philharmonic.venues.cinema.domain.Cinema;
import com.npopov.philharmonic.venues.cinema.repository.CinemaRepository;
import org.springframework.stereotype.Service;

@Service
public class CinemaService extends JpaCrudService<Cinema, Long> {

    private final CinemaRepository cinemaRepository;

    public CinemaService(CinemaRepository cinemaRepository) {
        super(cinemaRepository);
        this.cinemaRepository = cinemaRepository;
    }
}
