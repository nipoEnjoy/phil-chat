package com.npopov.philharmonic.shared.controller;

import com.npopov.philharmonic.shared.exception.ResourceNotFoundException;
import com.npopov.philharmonic.shared.service.CrudService;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @param <E>
 *     Entity
 * @param <ID>
 *     id type (Long/Int)
 * @param <R>
 *     Response record
 * @param <C>
 *     Create request record
 * @param <U>
 *     Update request record
 */

public class GenericRestController<E, ID, R, C, U> {

    protected final CrudService<E, ID> service;
    protected final Function<E, R> toResponse;
    protected final Function<C, E> fromCreate;
    protected final BiFunction<ID, U, E> fromUpdate;

    public GenericRestController(CrudService<E, ID> service,
                                 Function<E, R> toResponse,
                                 Function<C, E> fromCreate,
                                 BiFunction<ID, U, E> fromUpdate) {
        this.service = service;
        this.toResponse = toResponse;
        this.fromCreate = fromCreate;
        this.fromUpdate = fromUpdate;
    }

        public List<R> getAll() {
        return service.findAll().stream().map(toResponse).collect(Collectors.toList());
    }

    public ResponseEntity<R> getById(ID id) {
        return service.findById(id)
                .map(e -> ResponseEntity.ok(toResponse.apply(e)))
                .orElseThrow(() -> new ResourceNotFoundException("Resource with id " + id + " not found"));
    }

    public ResponseEntity<R> create(C createDto) {
        E saved = service.create(fromCreate.apply(createDto));
        return ResponseEntity.ok(toResponse.apply(saved));
    }

    public ResponseEntity<R> update(ID id, U updateDto) {
        if (service.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Resource with id " + id + " not found");
        }
        E entityToUpdate = fromUpdate.apply(id, updateDto);
        E saved = service.update(id, entityToUpdate);
        return ResponseEntity.ok(toResponse.apply(saved));
    }

    public ResponseEntity<Void> delete(ID id) {
        if (service.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}