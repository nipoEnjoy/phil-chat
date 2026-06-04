package com.npopov.philharmonic.impresario.controller;

import com.npopov.philharmonic.impresario.domain.Impresario;
import com.npopov.philharmonic.impresario.service.ImpresarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/impresarios")
public class ImpresarioController {

    private final ImpresarioService impresarioService;

    public ImpresarioController(ImpresarioService impresarioService) {
        this.impresarioService = impresarioService;
    }

    @GetMapping
    public List<Impresario> getAllImpresarios(@RequestParam(required = false) Long artistId, @RequestParam(required = false) String genre) {
        if (artistId != null) {
            return impresarioService.findByArtist(artistId);
        }
        if (genre != null) {
            return impresarioService.findByGenre(genre);
        }
        return impresarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Impresario> getImpresarioById(@PathVariable Long id) {
        return impresarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Impresario createImpresario(@RequestBody Impresario impresario) {
        return impresarioService.save(impresario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Impresario> updateImpresario(@PathVariable Long id, @RequestBody Impresario impresario) {
        if (!impresarioService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        impresario.setId(id);
        return ResponseEntity.ok(impresarioService.save(impresario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImpresario(@PathVariable Long id) {
        if (!impresarioService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        impresarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}