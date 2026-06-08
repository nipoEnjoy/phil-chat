package com.npopov.philharmonic.venues.theatre.service;

import com.npopov.philharmonic.shared.service.JpaCrudService;
import com.npopov.philharmonic.venues.theatre.domain.Theatre;
import com.npopov.philharmonic.venues.theatre.repository.TheatreRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TheatreService extends JpaCrudService<Theatre, Long> {

    private final TheatreRepository theatreRepository;

    public TheatreService(JpaRepository<Theatre, Long> repository, TheatreRepository theatreRepository) {
        super(repository);
        this.theatreRepository = theatreRepository;
    }
}
