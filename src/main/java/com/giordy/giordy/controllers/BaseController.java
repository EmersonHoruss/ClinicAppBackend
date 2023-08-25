package com.giordy.giordy.controllers;

import com.giordy.giordy.DTOs.entites.BaseDTO;
import com.giordy.giordy.DTOs.reponses.ResponseDTO;
import com.giordy.giordy.entities.Base;
import com.giordy.giordy.services.BaseService;
import com.giordy.giordy.utils.mappers.MapperBaseController;
import com.giordy.giordy.utils.specification.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public abstract class BaseController<E extends Base, S extends BaseService<E>, DTO extends BaseDTO> {
    @Autowired
    private S service;
    private MapperBaseController<E, DTO> mapper = new MapperBaseController(getClass());

    @GetMapping("")
    public ResponseEntity<?> get(@RequestParam(required = false) String query, Pageable pageable) {
        Page<E> entities = service.get(new Specification<E>(query), pageable);
        return ResponseEntity.status(HttpStatus.OK).body(entities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getById(@Valid @PathVariable Long id) {
        E entity = service.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.mapToDTO(entity));
    }

    @PostMapping("")
    public Object create(@Valid @RequestBody DTO entityDTO) {
        E entity = mapper.getMapperTypes().mapToEntity(entityDTO);
        entity = service.save(entity);

        //return ResponseEntity.status(HttpStatus.OK).body(mapper.mapToDTO(savedEntity));
        return entity;
    }

    @PutMapping("")
    public ResponseEntity<ResponseDTO> update(@Valid @RequestBody DTO entityDTO) {
        E entity = mapper.getMapperTypes().mapToEntity(entityDTO);
        E savedEntity = service.update(entity);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.mapToDTO(savedEntity));
    }

    @DeleteMapping("/{id}/{soft}")
    public ResponseEntity<ResponseDTO> delete(
            @Valid @PathVariable Long id,
            @Valid @PathVariable boolean soft) {
        System.out.println("soft: " + soft);
        E entity = null;
        if (soft) {
            entity = service.deleteSoft(id);
        } else {
            entity = service.deleteHard(id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(mapper.mapToDTO(entity));
    }
}
