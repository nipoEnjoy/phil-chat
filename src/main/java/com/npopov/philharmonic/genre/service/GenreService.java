package com.npopov.philharmonic.genre.service;

import com.npopov.philharmonic.genre.domain.Genre;
import com.npopov.philharmonic.genre.repository.GenreRepository;
import com.npopov.philharmonic.shared.service.JpaCrudService;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends JpaCrudService<Genre, Long> {

    public GenreService(GenreRepository repository) {
        super(repository);
    }

}
