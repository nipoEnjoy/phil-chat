package com.npopov.philharmonic.impresario.service;

import com.npopov.philharmonic.impresario.domain.Impresario;
import com.npopov.philharmonic.impresario.repository.ImpresarioRepository;
import com.npopov.philharmonic.shared.service.JpaCrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpresarioService extends JpaCrudService<Impresario, Long> {

    private final ImpresarioRepository impresarioRepository;

    public ImpresarioService(ImpresarioRepository impresarioRepository) {
        super(impresarioRepository);
        this.impresarioRepository = impresarioRepository;
    }

    public List<Impresario> findByArtist(Long artistId) {
        return impresarioRepository.findByArtistImpresarios_Artist_Id(artistId);
    }

    public List<Impresario> findByGenre(String genreName) {
        return impresarioRepository.findByGenre(genreName);
    }

    public void deleteById(Long id) {
        impresarioRepository.deleteById(id);
    }
}