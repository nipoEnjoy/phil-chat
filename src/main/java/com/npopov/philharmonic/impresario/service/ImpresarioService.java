package com.npopov.philharmonic.impresario.service;

import com.npopov.philharmonic.impresario.domain.Impresario;
import com.npopov.philharmonic.impresario.repository.ImpresarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpresarioService {

    private final ImpresarioRepository impresarioRepository;

    public ImpresarioService(ImpresarioRepository impresarioRepository) {
        this.impresarioRepository = impresarioRepository;
    }

    public List<Impresario> findAll() {
        return impresarioRepository.findAll();
    }

    public List<Impresario> findByArtist(Long artistId) {
        return impresarioRepository.findByArtistImpresarios_Artist_Id(artistId);
    }

    public List<Impresario> findByGenre(String genreName) {
        return impresarioRepository.findByGenre(genreName);
    }

    public Optional<Impresario> findById(Long id) {
        return impresarioRepository.findById(id);
    }

    public Impresario save(Impresario impresario) {
        return impresarioRepository.save(impresario);
    }

    public void deleteById(Long id) {
        impresarioRepository.deleteById(id);
    }
}